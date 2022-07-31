/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.elijah.task.controllers.test;

import com.elijah.task.utils.DashboardResponse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class DashboardControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void noParamDashboardShouldReturnDefaultDashboard() throws Exception {
            /*
             Calling the dashboard endpoint without the userId, should return 
            a dashboard with zero values.
            */

		this.mockMvc.perform(get("/api/dashboard")).andDo(print()).andExpect(status().isOk()).andExpect(content().json(
                "{\"loans\":0.0,\"paymentsSent\":0.0,\"paymentsRecieved\":0.0,\"total\":0.0}"));
	}

	@Test
	public void paramDashboardShouldReturnTailoredDashboard() throws Exception {
             /*
                Calling the transactions enndpoint with the userId should return
                HTTP 200 with the user's dashboard.
             */

		this.mockMvc.perform(get("/api/dashboard").param("userId", "62e179bbd3dcd9e9aab487cf1"))
				.andDo(print()).andExpect(status().isOk());
	}

}
