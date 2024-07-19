/*
 * Copyright 2017 Axway Software
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
package com.axway.ats.common.dbaccess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.PreparedStatement;
import com.axway.ats.common.PublicAtsApi;

public class DbQuerySetQueryTest {

	private DbQuery dbQuery;

	@BeforeEach
	public void setUp() {
		dbQuery = new DbQuery("");
	}

	@Test
	public void setValidQuery() {
		String validQuery = "SELECT * FROM users";
		dbQuery.setQuery(validQuery);
		assertEquals(validQuery, dbQuery.query);
	}

	@Test
	public void setEmptyQuery() {
		String emptyQuery = "";
		dbQuery.setQuery(emptyQuery);
		assertEquals(emptyQuery, dbQuery.query);
	}

	@Test
	public void setNullQuery() {
		dbQuery.setQuery(null);
		assertNull(dbQuery.query);
	}

	@Test
	public void setQueryWithSpecialCharacters() {
		String specialCharQuery = "SELECT * FROM users WHERE name = '@name'";
		dbQuery.setQuery(specialCharQuery);
		assertEquals(specialCharQuery, dbQuery.query);
	}

	@Test
	public void setQueryWithSQLKeywords() {
		String sqlKeywordsQuery = "SELECT * FROM users WHERE id = 1";
		dbQuery.setQuery(sqlKeywordsQuery);
		assertEquals(sqlKeywordsQuery, dbQuery.query);
	}

	@Test
	public void setQueryWithWhitespace() {
		String whitespaceQuery = "  SELECT * FROM users  ";
		dbQuery.setQuery(whitespaceQuery);
		assertEquals(whitespaceQuery, dbQuery.query);
	}

}