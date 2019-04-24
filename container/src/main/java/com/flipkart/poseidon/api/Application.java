/*
 * Copyright 2015 Flipkart Internet, pvt ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flipkart.poseidon.api;

import com.flipkart.poseidon.core.PoseidonRequest;
import com.flipkart.poseidon.core.PoseidonResponse;
import com.google.common.net.MediaType;
import flipkart.lego.api.exceptions.BadRequestException;
import flipkart.lego.api.exceptions.ElementNotFoundException;
import flipkart.lego.api.exceptions.InternalErrorException;
import flipkart.lego.api.exceptions.ProcessingException;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.ExecutorService;

public interface Application {

    void init(ExecutorService datasourceTPE, ExecutorService filterTPE, ApplicationContext context);

    void handleRequest(PoseidonRequest req, PoseidonResponse resp) throws ElementNotFoundException, BadRequestException, ProcessingException, InternalErrorException;

    MediaType getDefaultMediaType();

    default void stop() {}
}
