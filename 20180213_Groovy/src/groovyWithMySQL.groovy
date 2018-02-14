import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement


def host = "jdbc:mysql://turing.cs.missouriwestern.edu:3306/misc"
def user = "csc254"
def password="age126"

def queryString = "SELECT instnm, city, stabbr FROM post"

Connection conn = DriverManager.getConnection(host, user, password)
Statement st = conn.createStatement()
ResultSet rs = st.executeQuery(queryString)
def schools = []

def targetPhrase = System.in.newReader().readLine();
println "Looking for $targetPhrase"
def pattern = ~("(?i)"+targetPhrase)

while(rs.next()){
    def name = rs.getString("instnm")
    def city = rs.getString("city")
    def state= rs.getString("stabbr")
    University u = new University(name, city, state)
    if(u.toString() =~ pattern){
         schools.add(u)
    }
}

schools.each{
    println it
}





class University{
    String name;
    String city;
    String state

    University (name, city, state){
        this.name = name
        this.city = city
        this.state= state
    }
    String toString(){
        return "School: $name  City: $city, $state"
    }
}