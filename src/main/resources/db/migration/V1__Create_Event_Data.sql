CREATE TABLE event_data (
                            event_id BIGINT PRIMARY KEY,
                            subscription_id INT NOT NULL,
                            portal_id INT NOT NULL,
                            app_id INT NOT NULL,
                            occurred_at BIGINT NOT NULL,
                            subscription_type VARCHAR(255) NOT NULL,
                            attempt_number INT NOT NULL,
                            object_id BIGINT NOT NULL,
                            change_flag VARCHAR(50) NOT NULL,
                            change_source VARCHAR(50) NOT NULL,
                            source_id VARCHAR(50) NOT NULL
);
);
