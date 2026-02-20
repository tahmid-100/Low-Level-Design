# Notification Service

A flexible and extensible notification service system built using the **Strategy Design Pattern** in Java. This project demonstrates how to decouple notification logic from the alert mechanism, allowing multiple notification channels (Email, Slack, Webhooks) to be used interchangeably.

## Overview

The Notification Service provides a clean architecture for sending alerts through different channels without modifying the core business logic. It follows SOLID principles and makes it easy to add new notification strategies.

## Features

- 📧 **Email Notifications** - Send alerts via email
- 💬 **Slack Integration** - Post alerts to Slack channels
- 🔗 **Webhook Support** - Send notifications via HTTP webhooks
- 🔄 **Strategy Pattern** - Easily swap notification channels at runtime
- 🎯 **Dependency Injection** - Loose coupling between components
- 📦 **Extensible** - Simple to add new notification types

## Architecture

### Design Pattern: Strategy Pattern

The system uses the **Strategy Pattern** to encapsulate different notification algorithms. This allows clients to select a notification strategy at runtime.

### Class Diagram

```
┌─────────────────────────────────────────────────────────────────┐
│                   <<interface>>                                 │
│             NotificationService                                 │
├─────────────────────────────────────────────────────────────────┤
│                                                                 │
│  + send(String recipient, String message): void                │
│                                                                 │
└─────────────────┬───────────────────────────────────────────────┘
                  │
                  │ implements
      ┌───────────┼───────────┬──────────────────┐
      │           │           │                  │
      ▼           ▼           ▼                  ▼
┌──────────┐ ┌─────────┐ ┌──────────────┐ ┌─────────────┐
│  Email   │ │ Slack   │ │  Webhook     │ │   (Future)  │
│ Notifier │ │Notifier │ │  Notifier    │ │  Notifiers  │
├──────────┤ ├─────────┤ ├──────────────┤ └─────────────┘
│ - send() │ │- send() │ │  - send()    │
└──────────┘ └─────────┘ └──────────────┘


┌────────────────────────────────────────────────────────────────┐
│                    AlertService                                │
├────────────────────────────────────────────────────────────────┤
│                                                                │
│  - notifier: NotificationService                              │
│                                                                │
├────────────────────────────────────────────────────────────────┤
│                                                                │
│  + AlertService(NotificationService notifier)                 │
│  + triggerAlert(String recipient, String issue): void         │
│                                                                │
└────────────┬─────────────────────────────────────────────────┘
             │
             │ uses
             │
             ▼
     ┌─────────────────┐
     │ NotificationService
     └─────────────────┘
        (dependency)
```

## Components

### 1. **NotificationService** (Interface)
- Core interface defining the contract for all notification implementations
- Single method: `send(String recipient, String message)`

### 2. **EmailNotifier**
- Implements `NotificationService`
- Sends notifications via email
- Prints email notification to console

### 3. **SlackNotifier**
- Implements `NotificationService`
- Sends notifications to Slack channels
- Prints Slack notification to console

### 4. **WebhookNotifier**
- Implements `NotificationService`
- Sends notifications via HTTP webhooks
- Extensible for REST API integrations

### 5. **AlertService**
- Core business logic service
- Accepts a `NotificationService` implementation via dependency injection
- `triggerAlert()` method encapsulates the alert logic
- Delegates notification delivery to the injected strategy

## Usage Example

```java
// Create alert service with Email notifier
AlertService alertService = new AlertService(new EmailNotifier());
alertService.triggerAlert("admin@company.com", "Server down");

// Switch to Slack notifier at runtime
alertService = new AlertService(new SlackNotifier());
alertService.triggerAlert("alerts-channel", "High CPU usage detected");

// Use Webhook notifier
alertService = new AlertService(new WebhookNotifier());
alertService.triggerAlert("https://api.example.com/alerts", "Database error");
```

## Key Benefits

| Benefit | Description |
|---------|-------------|
| **Flexibility** | Swap notification strategies at runtime |
| **Extensibility** | Add new notification types without modifying existing code |
| **Testability** | Easy to mock `NotificationService` for unit tests |
| **Single Responsibility** | Each notifier handles one channel |
| **Open/Closed Principle** | Open for extension, closed for modification |
| **Loose Coupling** | `AlertService` depends on interface, not concrete classes |

## Getting Started

### Prerequisites
- Java 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

### Running the Application

```bash
javac *.java
java Main
```

## Extending the System

To add a new notification channel (e.g., SMS):

1. Create a new class implementing `NotificationService`:

```java
public class SMSNotifier implements NotificationService {
    @Override
    public void send(String recipient, String message) {
        System.out.println("SMS to " + recipient + "|| " + message);
    }
}
```

2. Use it with AlertService:

```java
AlertService alertService = new AlertService(new SMSNotifier());
alertService.triggerAlert("+1234567890", "Alert message");
```

## Project Structure

```
NotificationService/
├── NotificationService.java    (Interface)
├── EmailNotifier.java          (Implementation)
├── SlackNotifier.java          (Implementation)
├── WebhookNotifier.java        (Implementation)
├── AlertService.java           (Business Logic)
├── Main.java                   (Entry Point)
└── README.md                   (This file)
```

## Design Patterns Used

- **Strategy Pattern** - Encapsulates notification algorithms
- **Dependency Injection** - Constructor injection of NotificationService
- **Interface Segregation Principle** - Small, focused interface

## Future Enhancements

- [ ] Add SMS notifications
- [ ] Add push notification support
- [ ] Implement notification queuing
- [ ] Add retry logic for failed notifications
- [ ] Implement notification templates
- [ ] Add logging framework
- [ ] Implement async notifications

## License

This project is provided as-is for educational purposes.

## Author

Low Level Design Patterns - Notification Service Example
