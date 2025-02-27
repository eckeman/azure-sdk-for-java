// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.storage.blob.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.implementation.DateTimeRfc1123;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.time.OffsetDateTime;

/**
 * Properties of a container.
 */
@JacksonXmlRootElement(localName = "ContainerProperties")
@Fluent
public final class BlobContainerProperties {
    /*
     * The lastModified property.
     */
    @JsonProperty(value = "Last-Modified", required = true)
    private DateTimeRfc1123 lastModified;

    /*
     * The etag property.
     */
    @JsonProperty(value = "Etag", required = true)
    private String etag;

    /*
     * Possible values include: 'locked', 'unlocked'
     */
    @JsonProperty(value = "LeaseStatus")
    private LeaseStatusType leaseStatus;

    /*
     * Possible values include: 'available', 'leased', 'expired', 'breaking',
     * 'broken'
     */
    @JsonProperty(value = "LeaseState")
    private LeaseStateType leaseState;

    /*
     * Possible values include: 'infinite', 'fixed'
     */
    @JsonProperty(value = "LeaseDuration")
    private LeaseDurationType leaseDuration;

    /*
     * Possible values include: 'container', 'blob'
     */
    @JsonProperty(value = "PublicAccess")
    private PublicAccessType publicAccess;

    /*
     * The hasImmutabilityPolicy property.
     */
    @JsonProperty(value = "HasImmutabilityPolicy")
    private Boolean hasImmutabilityPolicy;

    /*
     * The hasLegalHold property.
     */
    @JsonProperty(value = "HasLegalHold")
    private Boolean hasLegalHold;

    /**
     * Get the lastModified property: The lastModified property.
     *
     * @return the lastModified value.
     */
    public OffsetDateTime getLastModified() {
        if (this.lastModified == null) {
            return null;
        }
        return this.lastModified.getDateTime();
    }

    /**
     * Set the lastModified property: The lastModified property.
     *
     * @param lastModified the lastModified value to set.
     * @return the ContainerProperties object itself.
     */
    public BlobContainerProperties setLastModified(OffsetDateTime lastModified) {
        if (lastModified == null) {
            this.lastModified = null;
        } else {
            this.lastModified = new DateTimeRfc1123(lastModified);
        }
        return this;
    }

    /**
     * Get the etag property: The etag property.
     *
     * @return the etag value.
     */
    public String getEtag() {
        return this.etag;
    }

    /**
     * Set the etag property: The etag property.
     *
     * @param etag the etag value to set.
     * @return the ContainerProperties object itself.
     */
    public BlobContainerProperties setEtag(String etag) {
        this.etag = etag;
        return this;
    }

    /**
     * Get the leaseStatus property: Possible values include: 'locked',
     * 'unlocked'.
     *
     * @return the leaseStatus value.
     */
    public LeaseStatusType getLeaseStatus() {
        return this.leaseStatus;
    }

    /**
     * Set the leaseStatus property: Possible values include: 'locked',
     * 'unlocked'.
     *
     * @param leaseStatus the leaseStatus value to set.
     * @return the ContainerProperties object itself.
     */
    public BlobContainerProperties setLeaseStatus(LeaseStatusType leaseStatus) {
        this.leaseStatus = leaseStatus;
        return this;
    }

    /**
     * Get the leaseState property: Possible values include: 'available',
     * 'leased', 'expired', 'breaking', 'broken'.
     *
     * @return the leaseState value.
     */
    public LeaseStateType getLeaseState() {
        return this.leaseState;
    }

    /**
     * Set the leaseState property: Possible values include: 'available',
     * 'leased', 'expired', 'breaking', 'broken'.
     *
     * @param leaseState the leaseState value to set.
     * @return the ContainerProperties object itself.
     */
    public BlobContainerProperties setLeaseState(LeaseStateType leaseState) {
        this.leaseState = leaseState;
        return this;
    }

    /**
     * Get the leaseDuration property: Possible values include: 'infinite',
     * 'fixed'.
     *
     * @return the leaseDuration value.
     */
    public LeaseDurationType getLeaseDuration() {
        return this.leaseDuration;
    }

    /**
     * Set the leaseDuration property: Possible values include: 'infinite',
     * 'fixed'.
     *
     * @param leaseDuration the leaseDuration value to set.
     * @return the ContainerProperties object itself.
     */
    public BlobContainerProperties setLeaseDuration(LeaseDurationType leaseDuration) {
        this.leaseDuration = leaseDuration;
        return this;
    }

    /**
     * Get the publicAccess property: Possible values include: 'container',
     * 'blob'.
     *
     * @return the publicAccess value.
     */
    public PublicAccessType getPublicAccess() {
        return this.publicAccess;
    }

    /**
     * Set the publicAccess property: Possible values include: 'container',
     * 'blob'.
     *
     * @param publicAccess the publicAccess value to set.
     * @return the ContainerProperties object itself.
     */
    public BlobContainerProperties setPublicAccess(PublicAccessType publicAccess) {
        this.publicAccess = publicAccess;
        return this;
    }

    /**
     * Get the hasImmutabilityPolicy property: The hasImmutabilityPolicy
     * property.
     *
     * @return the hasImmutabilityPolicy value.
     */
    public Boolean isHasImmutabilityPolicy() {
        return this.hasImmutabilityPolicy;
    }

    /**
     * Set the hasImmutabilityPolicy property: The hasImmutabilityPolicy
     * property.
     *
     * @param hasImmutabilityPolicy the hasImmutabilityPolicy value to set.
     * @return the ContainerProperties object itself.
     */
    public BlobContainerProperties setHasImmutabilityPolicy(Boolean hasImmutabilityPolicy) {
        this.hasImmutabilityPolicy = hasImmutabilityPolicy;
        return this;
    }

    /**
     * Get the hasLegalHold property: The hasLegalHold property.
     *
     * @return the hasLegalHold value.
     */
    public Boolean isHasLegalHold() {
        return this.hasLegalHold;
    }

    /**
     * Set the hasLegalHold property: The hasLegalHold property.
     *
     * @param hasLegalHold the hasLegalHold value to set.
     * @return the ContainerProperties object itself.
     */
    public BlobContainerProperties setHasLegalHold(Boolean hasLegalHold) {
        this.hasLegalHold = hasLegalHold;
        return this;
    }
}
