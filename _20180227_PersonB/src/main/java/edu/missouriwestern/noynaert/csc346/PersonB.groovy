package edu.missouriwestern.noynaert.csc346

import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class PersonB {
    static def getSections(String department){
        Section sec = null;
        def baseURL = "https://aps2.missouriwestern.edu/schedule/Default.asp?tck=201910"


        Document doc = null;

        /*Connection.Response response = Jsoup.connect(baseURL)
        .timeout(60 * 1000)
        .method(Connection.Method.POST)
        .data("course_number","")
        .data("subject","ALL")
        .data("department", department)
        .data("display_closed", "yes")
        .data("course_type","ALL")
        .followRedirects(true)
        .execute();

        doc = response.parse()
        */
        doc = Jsoup.parse(new File(department+".html"),"UTF-8")

        //System.out.println(doc)
        Elements rows = doc.select("tr")
        println("There are ${rows.size()} rows")

        rows.each{ row->
            def className = row.attr("class")

            Elements cells = row.select("td")
            if(className == "list_row"){
                if(sec != null){
                    println sec   //Add to database here!
                    sec = new Section()
                }
                //Going to be some code here
                sec.department = department
                sec.crn = cells.get(0).text().trim();  //works in Java or groovy
                sec.courseID = cells[1].text().trim()  //only works in groovy
            }

        }

    }
}
