package com.vk;

import static org.junit.Assert.assertThat;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FruitTest {

	@SuppressWarnings("unchecked")
	@Test
	public void testAssertMap() {

	
		Map<Integer, Fruit> map = new HashMap<Integer, Fruit>();
		map.put(1, new Fruit("Banana", 99));
		map.put(2, new Fruit("Apple", 20));
		map.put(3, new Fruit("Strawberry", 100));
		
		assertThat(map.values(), hasItems(new Fruit("Banana", 99), new Fruit("Apple", 20), new Fruit("Strawberry", 100))); 
		
		assertThat(map.values(), containsInAnyOrder(new Fruit("Banana", 99), new Fruit("Apple", 20),new Fruit("Strawberry", 100))); 
		assertThat(map.values(), containsInAnyOrder(
				hasProperty("name", is("Banana")),
				hasProperty("name", is("Apple")),
				hasProperty("name", is("Strawberry"))
			));
	}

}
