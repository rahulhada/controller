/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

/**
 * Generated file

 * Generated by: org.opendaylight.controller.config.yangjmxgenerator.plugin.JMXGenerator
 * Generated at: Wed Jul 17 15:26:45 CEST 2013
 *
 * Do not modifiy this file unless it is present under src/main directory
 */
package org.opendaylight.controller.config.yang.logback.config;

import com.google.common.collect.Sets;
import java.util.Set;
import org.opendaylight.controller.config.api.JmxAttribute;
import org.opendaylight.controller.config.api.JmxAttributeValidationException;

/**
*
*/
public final class LogbackModule extends org.opendaylight.controller.config.yang.logback.config.AbstractLogbackModule {

    public LogbackModule(final org.opendaylight.controller.config.api.ModuleIdentifier name,
            final org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
        super(name, dependencyResolver);
    }

    public LogbackModule(final org.opendaylight.controller.config.api.ModuleIdentifier name,
            final org.opendaylight.controller.config.api.DependencyResolver dependencyResolver,
            final org.opendaylight.controller.config.yang.logback.config.AbstractLogbackModule oldModule,
            final java.lang.AutoCloseable oldInstance) {
        super(name, dependencyResolver, oldModule, oldInstance);
    }

    @Override
    public void validate() {
        super.validate();
        Set<String> appenderNames = Sets.newHashSet();
        validateRollingObjects(appenderNames);
        validateConsoleObjects(appenderNames);
        validateFileObjects(appenderNames);
        validateLoggersObjects(appenderNames);
    }

    private void validateLoggersObjects(final Set<String> appenderNames) {
        JmxAttributeValidationException.checkNotNull(getLoggerTO(), loggersJmxAttribute);

        for (LoggerTO loggerToValidate : getLoggerTO()) {
            JmxAttributeValidationException.checkNotNull(loggerToValidate.getLoggerName(), "LoggerName is null",
                    loggersJmxAttribute);
            JmxAttributeValidationException.checkNotNull(loggerToValidate.getLevel(), "Level is null",
                    loggersJmxAttribute);
            JmxAttributeValidationException.checkCondition(!loggerToValidate.getLoggerName().isEmpty(),
                    "LoggerName needs to be set", loggersJmxAttribute);
            JmxAttributeValidationException.checkCondition(!loggerToValidate.getLevel().isEmpty(),
                    "Level needs to be set", loggersJmxAttribute);
            if (loggerToValidate.getAppenders() != null) {
                for (String appenderName : loggerToValidate.getAppenders()) {
                    JmxAttributeValidationException.checkCondition(appenderNames.contains(appenderName), "Appender "
                            + appenderName + " referenced by logger " + loggerToValidate.getLoggerName()
                            + " not present in configuration, present appenders: " + appenderNames, loggersJmxAttribute);
                }
            }

        }
    }

    private void validateConsoleObjects(final Set<String> appenderNames) {

        JmxAttributeValidationException.checkNotNull(getConsoleAppenderTO(), consoleAppendersJmxAttribute);
        for (ConsoleAppenderTO object : getConsoleAppenderTO()) {
            JmxAttributeValidationException.checkNotNull(object.getEncoderPattern(), "EncoderPattern is null",
                    consoleAppendersJmxAttribute);

            validateAppenderName(appenderNames, object.getName(), consoleAppendersJmxAttribute);

            JmxAttributeValidationException.checkNotNull(object.getThresholdFilter(), "Filterlevel is null",
                    consoleAppendersJmxAttribute);
        }
    }

    private void validateFileObjects(final Set<String> appenderNames) {
        JmxAttributeValidationException.checkNotNull(getFileAppenderTO(), fileAppendersJmxAttribute);
        for (FileAppenderTO object : getFileAppenderTO()) {
            JmxAttributeValidationException.checkNotNull(object.getEncoderPattern(), "EncoderPattern is null",
                    fileAppendersJmxAttribute);

            validateAppenderName(appenderNames, object.getName(), fileAppendersJmxAttribute);

            JmxAttributeValidationException.checkNotNull(object.getFileName(), "FileName is null",
                    fileAppendersJmxAttribute);
            JmxAttributeValidationException.checkCondition(!object.getEncoderPattern().isEmpty(),
                    "EncoderPattern needs to be set", fileAppendersJmxAttribute);
            JmxAttributeValidationException.checkCondition(!object.getFileName().isEmpty(), "FileName needs to be set",
                    fileAppendersJmxAttribute);

        }
    }

    private void validateRollingObjects(final Set<String> appenderNames) {

        JmxAttributeValidationException.checkNotNull(getRollingFileAppenderTO(), rollingAppendersJmxAttribute);
        for (RollingFileAppenderTO object : getRollingFileAppenderTO()) {
            JmxAttributeValidationException.checkNotNull(object.getEncoderPattern(), "EncoderPattern is null",
                    rollingAppendersJmxAttribute);

            validateAppenderName(appenderNames, object.getName(), rollingAppendersJmxAttribute);

            JmxAttributeValidationException.checkNotNull(object.getFileName(), "FileName is null",
                    rollingAppendersJmxAttribute);

            JmxAttributeValidationException.checkNotNull(object.getFileNamePattern(), "FileNamePattern is null",
                    rollingAppendersJmxAttribute);
            JmxAttributeValidationException.checkNotNull(object.getRollingPolicyType(), "RollingPolicyType is null",
                    rollingAppendersJmxAttribute);
            JmxAttributeValidationException.checkCondition(!object.getFileNamePattern().isEmpty(),
                    "FileNamePattern is not set", rollingAppendersJmxAttribute);
            JmxAttributeValidationException.checkCondition(!object.getRollingPolicyType().isEmpty(),
                    "RollingPolicyType is not set", rollingAppendersJmxAttribute);
            JmxAttributeValidationException.checkCondition(
                    (object.getRollingPolicyType().equals("FixedWindowRollingPolicy") || object.getRollingPolicyType()
                            .equals("TimeBasedRollingPolicy")), object.getRollingPolicyType()
                            + " RollingPolicyType is not supported", rollingAppendersJmxAttribute);

            if (object.getRollingPolicyType().equals("FixedWindowRollingPolicy")) {
                JmxAttributeValidationException.checkNotNull(object.getMinIndex(), "MinIndex is null",
                        rollingAppendersJmxAttribute);
                JmxAttributeValidationException.checkNotNull(object.getMaxIndex(), "MaxIndex is null",
                        rollingAppendersJmxAttribute);
            } else if (object.getRollingPolicyType().equals("TimeBasedRollingPolicy")) {
                JmxAttributeValidationException.checkNotNull(object.getMaxHistory(), "MaxHistory is null",
                        rollingAppendersJmxAttribute);
            }
            JmxAttributeValidationException.checkNotNull(object.getMaxFileSize(), "MaxFileSize is null",
                    rollingAppendersJmxAttribute);
            JmxAttributeValidationException.checkCondition(!object.getEncoderPattern().isEmpty(),
                    "EncoderPattern needs to be set", rollingAppendersJmxAttribute);
            JmxAttributeValidationException.checkCondition(!object.getFileName().isEmpty(), "FileName needs to be set",
                    rollingAppendersJmxAttribute);

        }
    }

    private void validateAppenderName(final Set<String> appenderNames, final String appenderName, final JmxAttribute jmxAttribute) {
        JmxAttributeValidationException.checkNotNull(appenderName, "Name is null", jmxAttribute);
        JmxAttributeValidationException.checkCondition(appenderNames.contains(appenderName) == false,
                "Duplicate appender name " + appenderName, jmxAttribute);
        appenderNames.add(appenderName);
        JmxAttributeValidationException.checkCondition(!appenderName.isEmpty(), "Name needs to be set", jmxAttribute);
    }

    @Override
    public java.lang.AutoCloseable createInstance() {
        ContextSetterImpl setter = new ContextSetterImpl(getRootRuntimeBeanRegistratorWrapper());

        setter.updateContext(this);

        return setter;
    }

}
