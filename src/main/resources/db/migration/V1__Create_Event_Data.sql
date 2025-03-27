CREATE TABLE event_data (
                            eventId BIGINT PRIMARY KEY,
                            subscriptionId INT NOT NULL,
                            portalId INT NOT NULL,
                            appId INT NOT NULL,
                            occurredAt BIGINT NOT NULL,
                            subscriptionType VARCHAR(255) NOT NULL,
                            attemptNumber INT NOT NULL,
                            objectId BIGINT NOT NULL,
                            changeFlag VARCHAR(50) NOT NULL,
                            changeSource VARCHAR(50) NOT NULL,
                            sourceId VARCHAR(50) NOT NULL
);
