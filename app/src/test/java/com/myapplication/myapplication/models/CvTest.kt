package com.myapplication.myapplication.models

import org.junit.Assert.*
import org.junit.Test

class CvTest{
    private val TENURE_1 = "Jan 2015 - Feb 2018"
    private val TENURE_2 = "March 2018 - July 2019"

    /*
      Test two equal cvs
    */
    @Test
    @Throws(Exception::class)
    fun cv_testEqualCompanies_returnsTrue() {

        val responsibilities = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val achievements = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val profSummary = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val techSkills = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val company1 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )
        val company2 = company1;


        val companies = arrayListOf<Company>()
        companies.add(company1)
        companies.add(company2)

        val cv1 = Cv(
            "Mrudula", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
            profSummary, techSkills, companies
        )
        val cv2 = cv1;

        assertEquals(cv1, cv2)
    }

    /*
     Test two  cvs  - diff names
   */
    @Test
    @Throws(Exception::class)
    fun cv_testDiffCompaniesWithDiffNames_returnsFalse() {

        val responsibilities = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val achievements = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val profSummary = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val techSkills = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val company1 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )
        val company2 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )


        val companies = arrayListOf<Company>()
        companies.add(company1)
        companies.add(company2)

        val cv1 = Cv(
            "Mrudula", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
            profSummary, techSkills, companies
        )
        val cv2 = Cv(
            "Hello", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
            profSummary, techSkills, companies
        )

        assertNotEquals(cv1, cv2)
    }


    /*
    Test two  cvs  - diff emails
  */
    @Test
    @Throws(Exception::class)
    fun cv_testDiffCompaniesWithDiffEmails_returnsFalse() {

        val responsibilities = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val achievements = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val profSummary = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val techSkills = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val company1 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )
        val company2 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )


        val companies = arrayListOf<Company>()
        companies.add(company1)
        companies.add(company2)

        val cv1 = Cv(
            "Mrudula", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
            profSummary, techSkills, companies
        )
        val cv2 = Cv(
            "Hello", "xxx@gmail.com", "+1 4328787w6767", "linked in",
            profSummary, techSkills, companies
        )

        assertNotEquals(cv1, cv2)
    }

    /*
    Test two  cvs  - diff phones
  */
    @Test
    @Throws(Exception::class)
    fun cv_testDiffCompaniesWithDiffPhones_returnsFalse() {

        val responsibilities = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val achievements = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val profSummary = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val techSkills = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val company1 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )
        val company2 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )


        val companies = arrayListOf<Company>()
        companies.add(company1)
        companies.add(company2)

        val cv1 = Cv(
            "Mrudula", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
            profSummary, techSkills, companies
        )
        val cv2 = Cv(
            "Hello", "mrudula@gmail.com", "+1 77665454345", "linked in",
            profSummary, techSkills, companies
        )

        assertNotEquals(cv1, cv2)
    }

    /*
    Test two  cvs  - diff linked in
  */
    @Test
    @Throws(Exception::class)
    fun cv_testDiffCompaniesWithDiffTenures_returnsFalse() {

        val responsibilities = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val achievements = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val profSummary = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val techSkills = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val company1 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )
        val company2 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )


        val companies = arrayListOf<Company>()
        companies.add(company1)
        companies.add(company2)

        val cv1 = Cv(
            "Mrudula", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
            profSummary, techSkills, companies
        )
        val cv2 = Cv(
            "Hello", "mrudula@gmail.com", "+1 4328787w6767", "asdjhdhghsgd in",
            profSummary, techSkills, companies
        )

        assertNotEquals(cv1, cv2)
    }

    /*
    Test two  cvs  - diff profsummary
  */
    @Test
    @Throws(Exception::class)
    fun cv_testDiffCompaniesWithDiffProfSummary_returnsFalse() {

        val responsibilities = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val achievements = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val profSummary = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val profSummary2 = arrayListOf<String>()
        responsibilities.add("four")
        responsibilities.add("five")
        responsibilities.add("six")

        val techSkills = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val company1 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )
        val company2 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )


        val companies = arrayListOf<Company>()
        companies.add(company1)
        companies.add(company2)

        val cv1 = Cv(
            "Mrudula", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
            profSummary, techSkills, companies
        )
        val cv2 = Cv(
            "Hello", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
            profSummary2, techSkills, companies
        )

        assertNotEquals(cv1, cv2)
    }

    /*
 Test two  cvs  - diff profsummary
*/
    @Test
    @Throws(Exception::class)
    fun cv_testDiffCompaniesWithDiffTechSkills_returnsFalse() {

        val responsibilities = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val achievements = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val profSummary = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val techSkills = arrayListOf<String>()
        responsibilities.add("One")
        responsibilities.add("Two")
        responsibilities.add("Three")

        val techSkills2 = arrayListOf<String>()
        responsibilities.add("four")
        responsibilities.add("five")
        responsibilities.add("six")

        val company1 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )
        val company2 = Company(
            "Company", "Logo", "Role 1",
            TENURE_1, "location", responsibilities, achievements
        )


        val companies = arrayListOf<Company>()
        companies.add(company1)
        companies.add(company2)

        val cv1 = Cv(
            "Mrudula", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
            profSummary, techSkills, companies
        )
        val cv2 = Cv(
            "Hello", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
            profSummary, techSkills2, companies
        )

        assertNotEquals(cv1, cv2)
    }
}