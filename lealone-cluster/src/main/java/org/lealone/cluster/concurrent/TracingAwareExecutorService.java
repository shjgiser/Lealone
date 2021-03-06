/*
 * 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * 
 */

package org.lealone.cluster.concurrent;

import java.util.concurrent.ExecutorService;

import org.lealone.cluster.tracing.TraceState;

public interface TracingAwareExecutorService extends ExecutorService {
    // we need a way to inject a TraceState directly into the Executor context without going through
    // the global Tracing sessions; see lealone-5668
    public void execute(Runnable command, TraceState state);

    // permits executing in the context of the submitting thread
    public void maybeExecuteImmediately(Runnable command);
}
