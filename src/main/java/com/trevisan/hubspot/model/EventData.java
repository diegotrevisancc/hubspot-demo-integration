package com.trevisan.hubspot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="event_data")
public class EventData {

  private Long appId;
  @Id
  private Long eventId;
  private Long subscriptionId;
  private Long portalId;
  private Long occurredAt;
  private String subscriptionType;
  private Long attemptNumber;
  private Long objectId;
  private String changeSource;
  private String changeFlag;

  public EventData() {
  }

  public EventData(Long appId, Long eventId, Long subscriptionId, Long portalId, Long occurredAt, String subscriptionType, Long attemptNumber, Long objectId, String changeSource, String changeFlag) {
    this.appId = appId;
    this.eventId = eventId;
    this.subscriptionId = subscriptionId;
    this.portalId = portalId;
    this.occurredAt = occurredAt;
    this.subscriptionType = subscriptionType;
    this.attemptNumber = attemptNumber;
    this.objectId = objectId;
    this.changeSource = changeSource;
    this.changeFlag = changeFlag;
  }

  public Long getAppId() {
    return appId;
  }

  public void setAppId(Long appId) {
    this.appId = appId;
  }

  public Long getEventId() {
    return eventId;
  }

  public void setEventId(Long eventId) {
    this.eventId = eventId;
  }

  public Long getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(Long subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public Long getPortalId() {
    return portalId;
  }

  public void setPortalId(Long portalId) {
    this.portalId = portalId;
  }

  public Long getOccurredAt() {
    return occurredAt;
  }

  public void setOccurredAt(Long occurredAt) {
    this.occurredAt = occurredAt;
  }

  public String getSubscriptionType() {
    return subscriptionType;
  }

  public void setSubscriptionType(String subscriptionType) {
    this.subscriptionType = subscriptionType;
  }

  public Long getAttemptNumber() {
    return attemptNumber;
  }

  public void setAttemptNumber(Long attemptNumber) {
    this.attemptNumber = attemptNumber;
  }

  public Long getObjectId() {
    return objectId;
  }

  public void setObjectId(Long objectId) {
    this.objectId = objectId;
  }

  public String getChangeSource() {
    return changeSource;
  }

  public void setChangeSource(String changeSource) {
    this.changeSource = changeSource;
  }

  public String getChangeFlag() {
    return changeFlag;
  }

  public void setChangeFlag(String changeFlag) {
    this.changeFlag = changeFlag;
  }
}
