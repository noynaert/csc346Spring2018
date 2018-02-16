//Maps or Associative Arrays or Hashes or Dictionaries

today = [:]
today["year"] = 2018
today["month"] = 02
today["day"] = 15
today["name"] = "Thursday"
today."weather" = "warm"
today.put("mood", "happy")
today.name = "Thu"
today.remove"mood"
print today

today.each{data ->
    println data
}
today.each{
    println it
}
println "FIELDS"
def fieldNames = today.keySet();
println "Fields are $fieldNames"
fieldNames.each{
    println it
}
println "VALUES"
def values = today.values()
values.each{v ->
    println "The value is $v"
}

def job = ["name":"Thu", "time": ["hour":8, "minute":30]]
println $job

println "Intersection: ${today.intersect(job)}"

def calendar = today + job
println calendar