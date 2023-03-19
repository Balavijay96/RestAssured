package com.RestAssured;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute;
import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;

public class FilterPredicate {
	public static File jsonPath;
	private void inlinePredicate() throws IOException {
		jsonPath=new File("C:\\Users\\Bala\\study\\eclipse-workspace\\RestAssured\\src\\main\\resources\\booksjsonpath.json");
		List<Map<String,Object>> read = JsonPath
			.parse(jsonPath)
			.read("$..book[?(@.price>10 && @.category=='fiction')]");
		Object read1 = read.get(0).get("author");
		System.out.println(read1);
				
	}
	public void FilterPredicateEg() throws IOException {
			Filter filter = Filter.filter(
					Criteria
					.where("price")
						.gt(20));
			List<Object> read = JsonPath
			.parse(jsonPath)
			.read("$..book[?]",filter);
			
			System.out.println("Second Method "+ read);
	}
	
	private void secondFilter() throws IOException {
		Filter filter = Filter.filter(
				Criteria
				.where("category")
				.is("fiction")
					
					.and("price")
					.lt(10));
		List<Object> read = JsonPath
		.parse(jsonPath)
		.read("$..book[?]",filter);
		
		System.out.println("Third Method :"+read);		
			
	}
	
	private void customPredicate() {
	//			Predicate p= new Predicate();
				com.jayway.jsonpath.Predicate books=ctx->ctx.item(Map.class).containsKey("isbn");
	}

	public static void main(String[] args) throws IOException {
		FilterPredicate obj= new FilterPredicate();
		obj.inlinePredicate();
		obj.FilterPredicateEg();
		obj.secondFilter();
	}
}
