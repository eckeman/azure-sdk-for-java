/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.servicefabric;

import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.microsoft.azure.servicefabric.implementation.ApplicationEventInner;

/**
 * Process Exited event.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "Kind")
@JsonTypeName("ApplicationProcessExited")
public class ApplicationProcessExitedEvent extends ApplicationEventInner {
    /**
     * Name of Service.
     */
    @JsonProperty(value = "ServiceName", required = true)
    private String serviceName;

    /**
     * Name of Service package.
     */
    @JsonProperty(value = "ServicePackageName", required = true)
    private String servicePackageName;

    /**
     * Activation Id of Service package.
     */
    @JsonProperty(value = "ServicePackageActivationId", required = true)
    private String servicePackageActivationId;

    /**
     * Indicates IsExclusive flag.
     */
    @JsonProperty(value = "IsExclusive", required = true)
    private boolean isExclusive;

    /**
     * Name of Code package.
     */
    @JsonProperty(value = "CodePackageName", required = true)
    private String codePackageName;

    /**
     * Type of EntryPoint.
     */
    @JsonProperty(value = "EntryPointType", required = true)
    private String entryPointType;

    /**
     * Name of executable.
     */
    @JsonProperty(value = "ExeName", required = true)
    private String exeName;

    /**
     * Process Id.
     */
    @JsonProperty(value = "ProcessId", required = true)
    private long processId;

    /**
     * Host Id.
     */
    @JsonProperty(value = "HostId", required = true)
    private String hostId;

    /**
     * Exit code of process.
     */
    @JsonProperty(value = "ExitCode", required = true)
    private long exitCode;

    /**
     * Indicates if termination is unexpected.
     */
    @JsonProperty(value = "UnexpectedTermination", required = true)
    private boolean unexpectedTermination;

    /**
     * Start time of process.
     */
    @JsonProperty(value = "StartTime", required = true)
    private DateTime startTime;

    /**
     * Get name of Service.
     *
     * @return the serviceName value
     */
    public String serviceName() {
        return this.serviceName;
    }

    /**
     * Set name of Service.
     *
     * @param serviceName the serviceName value to set
     * @return the ApplicationProcessExitedEvent object itself.
     */
    public ApplicationProcessExitedEvent withServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    /**
     * Get name of Service package.
     *
     * @return the servicePackageName value
     */
    public String servicePackageName() {
        return this.servicePackageName;
    }

    /**
     * Set name of Service package.
     *
     * @param servicePackageName the servicePackageName value to set
     * @return the ApplicationProcessExitedEvent object itself.
     */
    public ApplicationProcessExitedEvent withServicePackageName(String servicePackageName) {
        this.servicePackageName = servicePackageName;
        return this;
    }

    /**
     * Get activation Id of Service package.
     *
     * @return the servicePackageActivationId value
     */
    public String servicePackageActivationId() {
        return this.servicePackageActivationId;
    }

    /**
     * Set activation Id of Service package.
     *
     * @param servicePackageActivationId the servicePackageActivationId value to set
     * @return the ApplicationProcessExitedEvent object itself.
     */
    public ApplicationProcessExitedEvent withServicePackageActivationId(String servicePackageActivationId) {
        this.servicePackageActivationId = servicePackageActivationId;
        return this;
    }

    /**
     * Get indicates IsExclusive flag.
     *
     * @return the isExclusive value
     */
    public boolean isExclusive() {
        return this.isExclusive;
    }

    /**
     * Set indicates IsExclusive flag.
     *
     * @param isExclusive the isExclusive value to set
     * @return the ApplicationProcessExitedEvent object itself.
     */
    public ApplicationProcessExitedEvent withIsExclusive(boolean isExclusive) {
        this.isExclusive = isExclusive;
        return this;
    }

    /**
     * Get name of Code package.
     *
     * @return the codePackageName value
     */
    public String codePackageName() {
        return this.codePackageName;
    }

    /**
     * Set name of Code package.
     *
     * @param codePackageName the codePackageName value to set
     * @return the ApplicationProcessExitedEvent object itself.
     */
    public ApplicationProcessExitedEvent withCodePackageName(String codePackageName) {
        this.codePackageName = codePackageName;
        return this;
    }

    /**
     * Get type of EntryPoint.
     *
     * @return the entryPointType value
     */
    public String entryPointType() {
        return this.entryPointType;
    }

    /**
     * Set type of EntryPoint.
     *
     * @param entryPointType the entryPointType value to set
     * @return the ApplicationProcessExitedEvent object itself.
     */
    public ApplicationProcessExitedEvent withEntryPointType(String entryPointType) {
        this.entryPointType = entryPointType;
        return this;
    }

    /**
     * Get name of executable.
     *
     * @return the exeName value
     */
    public String exeName() {
        return this.exeName;
    }

    /**
     * Set name of executable.
     *
     * @param exeName the exeName value to set
     * @return the ApplicationProcessExitedEvent object itself.
     */
    public ApplicationProcessExitedEvent withExeName(String exeName) {
        this.exeName = exeName;
        return this;
    }

    /**
     * Get process Id.
     *
     * @return the processId value
     */
    public long processId() {
        return this.processId;
    }

    /**
     * Set process Id.
     *
     * @param processId the processId value to set
     * @return the ApplicationProcessExitedEvent object itself.
     */
    public ApplicationProcessExitedEvent withProcessId(long processId) {
        this.processId = processId;
        return this;
    }

    /**
     * Get host Id.
     *
     * @return the hostId value
     */
    public String hostId() {
        return this.hostId;
    }

    /**
     * Set host Id.
     *
     * @param hostId the hostId value to set
     * @return the ApplicationProcessExitedEvent object itself.
     */
    public ApplicationProcessExitedEvent withHostId(String hostId) {
        this.hostId = hostId;
        return this;
    }

    /**
     * Get exit code of process.
     *
     * @return the exitCode value
     */
    public long exitCode() {
        return this.exitCode;
    }

    /**
     * Set exit code of process.
     *
     * @param exitCode the exitCode value to set
     * @return the ApplicationProcessExitedEvent object itself.
     */
    public ApplicationProcessExitedEvent withExitCode(long exitCode) {
        this.exitCode = exitCode;
        return this;
    }

    /**
     * Get indicates if termination is unexpected.
     *
     * @return the unexpectedTermination value
     */
    public boolean unexpectedTermination() {
        return this.unexpectedTermination;
    }

    /**
     * Set indicates if termination is unexpected.
     *
     * @param unexpectedTermination the unexpectedTermination value to set
     * @return the ApplicationProcessExitedEvent object itself.
     */
    public ApplicationProcessExitedEvent withUnexpectedTermination(boolean unexpectedTermination) {
        this.unexpectedTermination = unexpectedTermination;
        return this;
    }

    /**
     * Get start time of process.
     *
     * @return the startTime value
     */
    public DateTime startTime() {
        return this.startTime;
    }

    /**
     * Set start time of process.
     *
     * @param startTime the startTime value to set
     * @return the ApplicationProcessExitedEvent object itself.
     */
    public ApplicationProcessExitedEvent withStartTime(DateTime startTime) {
        this.startTime = startTime;
        return this;
    }

}
