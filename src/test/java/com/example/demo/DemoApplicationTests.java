package com.example.demo;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.controller.ExampleController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class DemoApplicationTests {
	private MockMvc mvc;

	@Before
	public void Setup() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new ExampleController()).build();
	}

//	@Test
//	public void contextLoads() throws Exception{
//		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
//		        .andExpect(status().isOk())
//		        .andExpect(content().string(equalTo("index")));
//		
//
//	}
	@Test
	public void testExampleController() throws Exception {
		RequestBuilder request = null;
		// get查看users是不是一個空列表
		 request = get("/users/");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
		// post提交一個user,查看是否成功
		request = post("/users/").param("name", "nana").param("id", "1").param("age", "12");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("Success")));
		// get获取刚刚插入的数据的列表
		request = get("/users/");
		mvc.perform(request).andExpect(status().isOk())
				.andExpect(content().string(equalTo("[{\"name\":\"nana\",\"id\":1,\"age\":12}]"))).andDo(print());
		// put更新了一个user信息，查看是否更新成功
		request = put("/users/1").param("name", "tutu").param("age", "12");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("success")));
        //get指定id的数据列表
				request = get("/users/1");
				mvc.perform(request).andExpect(status().isOk())
						.andExpect(content().string(equalTo("{\"name\":\"tutu\",\"id\":1,\"age\":12}")));
	}

}
