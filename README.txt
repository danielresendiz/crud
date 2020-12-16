# crud
springboot
//guia de como usar el CRUD
//las funciones de mostrar se ejecutan en el navegador
// las funciones de crear, actualizar y borrar son con la ayuda de postman insertando los siguientes json y url
---------regions------------

consultar 	 http://localhost:8080/regions/list/2 el id es opcional para consultar un elemento en especifico
actualizar/crear http://localhost:8080/regions/(create,update) segun sea el caso
borrar  	 http://localhost:8080/regions/delete/2 id que se va eliminar
{
	"regionID": "2",
	"regionName": "America",
}
---------country------------
consultar 	 http://localhost:8080/countries/list/AA el id es opcional para consultar un elemento en especifico
actualizar/crear http://localhost:8080/countries/(create,update) segun sea el caso
borrar  	 http://localhost:8080/countries/delete/AA id que se va eliminar
{    
	"countryID": "AA",
	"countryName": "Argelia",
	"regionID": { "regionID":4  }
}
---------locations----------
consultar 	 http://localhost:8080/locations/list/1000 el id es opcional para consultar un elemento en especifico
actualizar/crear http://localhost:8080/locations/(create,update) segun sea el caso
borrar  	 http://localhost:8080/locations/delete/1000 id que se va eliminar

{
	"locationID": 1000,
	"streetAddres": "1297 Via Cola di Rie",
	"postalCode": "00989",
	"city": "Roma",
	"stateProvince": null,
	"countryID": { "countryID":"IT"}
}
---------departments--------
consultar 	 http://localhost:8080/locations/list/10 el id es opcional para consultar un elemento en especifico
actualizar/crear http://localhost:8080/locations/(create,update) segun sea el caso
borrar  	 http://localhost:8080/locations/delete/10 id que se va eliminar
{
	"departmentID": 10,
	"departmentName": "Administration",
	"managerID": 200,
	"locationID": { "locationID":1200}
}
---------job----------------
consultar 	 http://localhost:8080/jobs/list/AA_RES el id es opcional para consultar un elemento en especifico
actualizar/crear http://localhost:8080/jobs/(create,update) segun sea el caso
borrar  	 http://localhost:8080/jobs/delete/AA_RES id que se va eliminar
{    
	"jobID": "AA_RES",
	"jobTitle": "Engginner",
	"minSalary":1000.0,
	"maxSalary":5000.0
}
---------jobHistory---------
consultar 	 http://localhost:8080/jobsHitory/list/2001-01-13 el id es opcional para consultar un elemento en especifico
actualizar/crear http://localhost:8080/jobsHitory/(create,update) segun sea el caso
borrar  	 http://localhost:8080/jobsHitory/delete/2001-01-13 id que se va eliminar
{
    "employeeID": 102,
    "startDate": "2001-01-13T06:00:00.000+00:00",
    "endDate": "2006-07-24T05:00:00.000+00:00",
    "jobID": "IT_PROG",
    "departmentID": 60
}
---------employess----------
consultar 	 http://localhost:8080/employees/list/1000 el id es opcional para consultar un elemento en especifico
actualizar/crear http://localhost:8080/employees/(create,update) segun sea el caso
borrar  	 http://localhost:8080/employees/delete/1000 id que se va eliminar
{
    "firstName": "Daniel",
    "lastName": "Rodriguez",
    "email": "nuevoemailsiempre",
    "phoneNumbre": "515.123.4567",
    "hireDate": "2003-06-17T05:00:00.000+00:00",
    "jobID": "AD_PRES",
    "salary": 24000.0,
    "commissionPCT": null,
    "managerID": null,
    "departmentID": 90,
    "employeID": 93
}
