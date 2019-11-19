package com.myapplication.myapplication.models

import org.junit.Assert.*
import org.junit.Test

class CompanyTest{

    private val TENURE_1 = "Jan 2015 - Feb 2018"
    private val TENURE_2 = "March 2018 - July 2019"

    /*
       Test two equal companies
     */
    @Test
    @Throws(Exception::class)
    fun company_testEqualCompanies_returnsTrue() {

        val responsibilities = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val achievements =  arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val company1 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )
        val company2 = company1

        assertEquals(company1, company2)
    }

    /*
      Test companies with different names
    */
    @Test
    @Throws(Exception::class)
    fun company_testCompaniesWithDifNames_returnsFalse() {
        val responsibilities = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val achievements = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val company1 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )
        val company2 = Company(
            "Company two", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )

        assertNotEquals(company1, company2)
    }

    /*
      Test companies with different logos
    */
    @Test
    @Throws(Exception::class)
    fun company_testCompaniesWithDifLogos_returnsFalse() {
        val responsibilities = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val achievements = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val company1 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )
        val company2 = Company(
            "Company", "Logo two", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )

        assertNotEquals(company1, company2)
    }

    /*
    Test companies with different tenures
  */
    @Test
    @Throws(Exception::class)
    fun company_testCompaniesWithDifRoles_returnsFalse() {
        val responsibilities = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val achievements = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val company1 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )
        val company2 = Company(
            "Company", "Logo", "Role 2",
            TENURE_1, "location", responsibilities, achievements
        )

        assertNotEquals(company1, company2)
    }

    /*
      Test companies with different locations
    */
    @Test
    @Throws(Exception::class)
    fun company_testCompaniesWithDifTenures_returnsFalse() {
        val responsibilities = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val achievements = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val company1 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )
        val company2 = Company(
            "Company", "Logo", "Role 2",
            TENURE_2, "location", responsibilities, achievements
        )

        assertNotEquals(company1, company2)
    }

    /*
      Test companies with different names
    */
    @Test
    @Throws(Exception::class)
    fun company_testCompaniesWithDifLocations_returnsFalse() {
        val responsibilities = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val achievements = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val company1 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )
        val company2 = Company(
            "Company two", "Logo", "Role 1",
            TENURE_1, "location 2", responsibilities, achievements
        )

        assertNotEquals(company1, company2)
    }

    /*
      Test companies with different names
    */
    @Test
    @Throws(Exception::class)
    fun company_testCompaniesWithDifNResponsibilities_returnsFalse() {
        val responsibilities = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val responsibilities_2 = arrayListOf<String>()
        responsibilities.add("Seven")
        responsibilities.add("Six")
        responsibilities.add("Fours")

        val achievements = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val company1 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )
        val company2 = Company(
            "Company two", "Logo", "Role 1",
            TENURE_1, "location", responsibilities_2, achievements
        )

        assertNotEquals(company1, company2)
    }

    /*
      Test companies with different achievements
    */
    @Test
    @Throws(Exception::class)
    fun company_testCompaniesWithDifAchievements_returnsFalse() {
        val responsibilities = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val achievements = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val achievements_2 = arrayListOf<String>()
        responsibilities.add("six")
        responsibilities.add("seven")
        responsibilities.add("Five")

        val company1 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )
        val company2 = Company(
            "Company two", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements_2
        )

        assertNotEquals(company1, company2)
    }

}