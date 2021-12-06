package com.unitest.junitest.logic;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.unitest.junitest.logic.Formula;

class JUnitSimpleTest {		

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	@Test
	@DisplayName("Check Want to except null pointer exception")
	void testNullException() throws Exception {	
		Exception exception = assertThrows(
				NullPointerException.class, 
				() -> Formula.getConcat(null));
		/*
		 * mksdnya adalah di unit codenya throws null pointer exception
		 * test casenya mau resultnya dpt null pointer exception
		 * dibuatkan assertthrows / catch untuk nullpointer
		 * tetapi dikarenakan ada error lain krn salah logic oleh developer
		 * proses test case gagal, solusinya jgn buat manual test casenya untuk
		 * handle error yang lain / tambah catch lain, tetapi gunakan throws exception aja , dimana
		 * 1. di dlm menulis test case harus sesimple mungkin *ingat tujuannya unit test : input dan output
		 * 2. best practice handle exception di test method di handle oleh test java tersebut.
		 * jadi mksdnya jgn dibiarkan error tnp catch tidak bagus di java
		 * */
	        assertTrue(exception.getMessage().contains("is null"));
	}	

	@Test
	@DisplayName("Check Multiple")
	void testMultiple() {
		assertEquals(10, Formula.getMultiple(2, 5));
	}
	
	@Test
	@DisplayName("Check Formula to find maximum number")
	void testMax() {
		assertEquals(4, Formula.findMax(new int[] { 1, 3, 4, 2 }));		
	}
	
	@Test
	@DisplayName("Check greater value")
	void testTrue() {
		assertTrue(5 > 4,"5 lebih besar dari 4");
	}
	
	@Test
	@DisplayName("Check Null Object")
	void testNull() {
		Object object = null;
		assertNull(object,"The object should be null");
	}

	@Test
	@DisplayName("Check Object same reference")
	void testSame() {
		Map<String, String> obj1 = new HashMap<String, String>();
		Map<String, String> obj2 = obj1;
		assertSame(obj1, obj2,"Object Map is same reference");
	}
	
	@Nested
    @DisplayName("findOne methods")
    class FindOne {
        @Test
        @Disabled("Not Implemented yet")
        void findOne_with_id() {

        }

        @Test
        @Disabled("Not Implemented yet")
        void findWith_with_name() {

        }

        @Test
        @Disabled("Not Implemented yet")
        void findWith_with_name_regex() {

        }
    }

    @Nested
    @DisplayName("findAll methods")
    class FindAll {
        @Test
        @Disabled("Not Implemented yet")
        void findAll_with_ids() {

        }

        @Test
        @Disabled("Not Implemented yet")
        void findAll_with_name_likeY() {

        }
    }

    @Nested
    @DisplayName("update methods")
    class Update {
        @Test
        @Disabled("Not Implemented yet")
        void update_with_new() {

        }

        @Test
        @Disabled("Not Implemented yet")
        void update_with_existing() {

        }
    }

}
