---

excalidraw-plugin: parsed
tags: [excalidraw]

---
==⚠  Switch to EXCALIDRAW VIEW in the MORE OPTIONS menu of this document. ⚠==


# Text Elements
Cómo conectarse a una Base de Datos en Java? ^108IAjWj

- Primero creamos un try-catch.
- Creamos un objeto de tipo Connection que recibe un método getConnection de la clase DriverManager donde le pasaremos como parámetros:
    - El tipo de conexión->String
    - El usuario de la BD->String
    - La contraseña del usuario->String
- Creamos la consulta sql en String.
- Creamos un objeto de tipo Statement que recibe un método del objeto Connection creado anteriormente.
-  Ejecutamos la sentencia con el método executeUpdate o el tipo necesario del objeto Statement.
       ^je673rp6

BD ^Q3BWQKIP

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateFile {
    public static void main(String[] args){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql:"+"/db_ejemplos", "root", "");
            String query = "CREATE TABLE LIBRO(isbn varchar(100) NOT NULL,name varchar(100) NOT NULL,PRIMARY KEY(isbn))";
            Statement stmt = con.createStatement();
            String query1 = "INSERT INTO LIBRO(isbn, name) values('232323sf', 'wdrwer')";
            stmt.executeUpdate(query1);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
} ^io8YL78I

%%
# Drawing
```json
{
	"type": "excalidraw",
	"version": 2,
	"source": "https://excalidraw.com",
	"elements": [
		{
			"type": "rectangle",
			"version": 523,
			"versionNonce": 1105615965,
			"isDeleted": false,
			"id": "5Ko1bEWldMFFRVfnaZ-7S",
			"fillStyle": "hachure",
			"strokeWidth": 1,
			"strokeStyle": "solid",
			"roughness": 1,
			"opacity": 100,
			"angle": 0,
			"x": 432.8043344179061,
			"y": -667.7792879750095,
			"strokeColor": "#000000",
			"backgroundColor": "transparent",
			"width": 519,
			"height": 70,
			"seed": 786168029,
			"groupIds": [],
			"strokeSharpness": "sharp",
			"boundElements": [],
			"updated": 1669742195509,
			"link": null,
			"locked": false
		},
		{
			"type": "text",
			"version": 510,
			"versionNonce": 1033150429,
			"isDeleted": false,
			"id": "108IAjWj",
			"fillStyle": "hachure",
			"strokeWidth": 1,
			"strokeStyle": "solid",
			"roughness": 1,
			"opacity": 100,
			"angle": 0,
			"x": 441.9458935211669,
			"y": -650.7807846631887,
			"strokeColor": "#000000",
			"backgroundColor": "transparent",
			"width": 497,
			"height": 25,
			"seed": 1289660669,
			"groupIds": [],
			"strokeSharpness": "sharp",
			"boundElements": [],
			"updated": 1669742188444,
			"link": null,
			"locked": false,
			"fontSize": 20,
			"fontFamily": 1,
			"text": "Cómo conectarse a una Base de Datos en Java?",
			"rawText": "Cómo conectarse a una Base de Datos en Java?",
			"baseline": 17,
			"textAlign": "left",
			"verticalAlign": "top",
			"containerId": null,
			"originalText": "Cómo conectarse a una Base de Datos en Java?"
		},
		{
			"type": "text",
			"version": 1121,
			"versionNonce": 1370847773,
			"isDeleted": false,
			"id": "je673rp6",
			"fillStyle": "hachure",
			"strokeWidth": 1,
			"strokeStyle": "solid",
			"roughness": 1,
			"opacity": 100,
			"angle": 0,
			"x": 116.9606271564823,
			"y": -558.075198664545,
			"strokeColor": "#000000",
			"backgroundColor": "transparent",
			"width": 1401,
			"height": 225,
			"seed": 1244204147,
			"groupIds": [],
			"strokeSharpness": "sharp",
			"boundElements": [],
			"updated": 1669741711382,
			"link": null,
			"locked": false,
			"fontSize": 20,
			"fontFamily": 1,
			"text": "- Primero creamos un try-catch.\n- Creamos un objeto de tipo Connection que recibe un método getConnection de la clase DriverManager donde le pasaremos como parámetros:\n    - El tipo de conexión->String\n    - El usuario de la BD->String\n    - La contraseña del usuario->String\n- Creamos la consulta sql en String.\n- Creamos un objeto de tipo Statement que recibe un método del objeto Connection creado anteriormente.\n-  Ejecutamos la sentencia con el método executeUpdate o el tipo necesario del objeto Statement.\n      ",
			"rawText": "- Primero creamos un try-catch.\n- Creamos un objeto de tipo Connection que recibe un método getConnection de la clase DriverManager donde le pasaremos como parámetros:\n    - El tipo de conexión->String\n    - El usuario de la BD->String\n    - La contraseña del usuario->String\n- Creamos la consulta sql en String.\n- Creamos un objeto de tipo Statement que recibe un método del objeto Connection creado anteriormente.\n-  Ejecutamos la sentencia con el método executeUpdate o el tipo necesario del objeto Statement.\n      ",
			"baseline": 217,
			"textAlign": "left",
			"verticalAlign": "top",
			"containerId": null,
			"originalText": "- Primero creamos un try-catch.\n- Creamos un objeto de tipo Connection que recibe un método getConnection de la clase DriverManager donde le pasaremos como parámetros:\n    - El tipo de conexión->String\n    - El usuario de la BD->String\n    - La contraseña del usuario->String\n- Creamos la consulta sql en String.\n- Creamos un objeto de tipo Statement que recibe un método del objeto Connection creado anteriormente.\n-  Ejecutamos la sentencia con el método executeUpdate o el tipo necesario del objeto Statement.\n      "
		},
		{
			"type": "line",
			"version": 2856,
			"versionNonce": 1637295645,
			"isDeleted": false,
			"id": "af84FWWoQd53Fp0M18kb2",
			"fillStyle": "solid",
			"strokeWidth": 1,
			"strokeStyle": "solid",
			"roughness": 1,
			"opacity": 100,
			"angle": 0,
			"x": 1021.1037384007179,
			"y": -676.3552471395623,
			"strokeColor": "#364fc7",
			"backgroundColor": "#228be6",
			"width": 101.43255738417912,
			"height": 117.61725800769342,
			"seed": 846764019,
			"groupIds": [
				"A-fpLu0ngBsnL_H2DmKCn",
				"wCuLmuTbjqZyxScX9Kjuu"
			],
			"strokeSharpness": "round",
			"boundElements": [],
			"updated": 1669742164380,
			"link": null,
			"locked": false,
			"startBinding": null,
			"endBinding": null,
			"lastCommittedPoint": null,
			"startArrowhead": null,
			"endArrowhead": null,
			"points": [
				[
					0,
					0
				],
				[
					0,
					81.24504586319145
				],
				[
					1.777062999357842,
					95.93711004248823
				],
				[
					13.975545169118597,
					101.33520266828153
				],
				[
					32.24595007890858,
					105.6036749382846
				],
				[
					51.72898522706211,
					106.7059820442988
				],
				[
					68.36290060874084,
					105.6069084227593
				],
				[
					83.9642241791822,
					102.88989158362904
				],
				[
					99.52537188642827,
					95.35807376427104
				],
				[
					100.58910440204657,
					81.24504586319145
				],
				[
					101.43255738417912,
					11.066502392818677
				],
				[
					100.15182896713623,
					-0.353787502790162
				],
				[
					87.54390769820083,
					-6.446029372429869
				],
				[
					73.39395832349102,
					-9.897171202621365
				],
				[
					54.99841378339567,
					-10.91127596339463
				],
				[
					43.322977231062616,
					-10.881763683096402
				],
				[
					18.460883213902022,
					-8.686704925433872
				],
				[
					0,
					0
				]
			]
		},
		{
			"type": "ellipse",
			"version": 1108,
			"versionNonce": 57382451,
			"isDeleted": false,
			"id": "YhXUkBU_E1DHyEDPPVinV",
			"fillStyle": "solid",
			"strokeWidth": 1,
			"strokeStyle": "solid",
			"roughness": 1,
			"opacity": 100,
			"angle": 0,
			"x": 1020.7302761234425,
			"y": -688.6801011672068,
			"strokeColor": "#364fc7",
			"backgroundColor": "#ffffff",
			"width": 101.25296680383022,
			"height": 27.53016315242473,
			"seed": 1089688765,
			"groupIds": [
				"A-fpLu0ngBsnL_H2DmKCn",
				"wCuLmuTbjqZyxScX9Kjuu"
			],
			"strokeSharpness": "sharp",
			"boundElements": [],
			"updated": 1669742164380,
			"link": null,
			"locked": false
		},
		{
			"type": "text",
			"version": 331,
			"versionNonce": 1801869949,
			"isDeleted": false,
			"id": "Q3BWQKIP",
			"fillStyle": "hachure",
			"strokeWidth": 2,
			"strokeStyle": "solid",
			"roughness": 1,
			"opacity": 100,
			"angle": 0,
			"x": 1055.7255031256097,
			"y": -568.6801011672068,
			"strokeColor": "#000000",
			"backgroundColor": "#228be6",
			"width": 33,
			"height": 25,
			"seed": 2049384851,
			"groupIds": [
				"Ec7wGrv2MZhP9i6dbBgnp",
				"wCuLmuTbjqZyxScX9Kjuu"
			],
			"strokeSharpness": "sharp",
			"boundElements": [],
			"updated": 1669742164380,
			"link": null,
			"locked": false,
			"fontSize": 20,
			"fontFamily": 1,
			"text": "BD",
			"rawText": "BD",
			"baseline": 17,
			"textAlign": "center",
			"verticalAlign": "top",
			"containerId": null,
			"originalText": "BD"
		},
		{
			"type": "text",
			"version": 294,
			"versionNonce": 249929213,
			"isDeleted": false,
			"id": "io8YL78I",
			"fillStyle": "hachure",
			"strokeWidth": 1,
			"strokeStyle": "solid",
			"roughness": 1,
			"opacity": 100,
			"angle": 0,
			"x": 283.949042418456,
			"y": -299.60130860197495,
			"strokeColor": "#0b7285",
			"backgroundColor": "transparent",
			"width": 1050,
			"height": 358,
			"seed": 1008328029,
			"groupIds": [],
			"strokeSharpness": "sharp",
			"boundElements": [],
			"updated": 1669741804554,
			"link": null,
			"locked": false,
			"fontSize": 16,
			"fontFamily": 1,
			"text": "import java.sql.Connection;\nimport java.sql.DriverManager;\nimport java.sql.Statement;\n\npublic class CreateFile {\n    public static void main(String[] args){\n        try{\n            Connection con = DriverManager.getConnection(\"jdbc:mysql:\"+\"/db_ejemplos\", \"root\", \"\");\n            String query = \"CREATE TABLE LIBRO(isbn varchar(100) NOT NULL,name varchar(100) NOT NULL,PRIMARY KEY(isbn))\";\n            Statement stmt = con.createStatement();\n            String query1 = \"INSERT INTO LIBRO(isbn, name) values('232323sf', 'wdrwer')\";\n            stmt.executeUpdate(query1);\n        }catch (Exception e) {\n            System.out.println(e.getMessage());\n        }\n    }\n}",
			"rawText": "import java.sql.Connection;\nimport java.sql.DriverManager;\nimport java.sql.Statement;\n\npublic class CreateFile {\n    public static void main(String[] args){\n        try{\n            Connection con = DriverManager.getConnection(\"jdbc:mysql:\"+\"/db_ejemplos\", \"root\", \"\");\n            String query = \"CREATE TABLE LIBRO(isbn varchar(100) NOT NULL,name varchar(100) NOT NULL,PRIMARY KEY(isbn))\";\n            Statement stmt = con.createStatement();\n            String query1 = \"INSERT INTO LIBRO(isbn, name) values('232323sf', 'wdrwer')\";\n            stmt.executeUpdate(query1);\n        }catch (Exception e) {\n            System.out.println(e.getMessage());\n        }\n    }\n}",
			"baseline": 351,
			"textAlign": "left",
			"verticalAlign": "top",
			"containerId": null,
			"originalText": "import java.sql.Connection;\nimport java.sql.DriverManager;\nimport java.sql.Statement;\n\npublic class CreateFile {\n    public static void main(String[] args){\n        try{\n            Connection con = DriverManager.getConnection(\"jdbc:mysql:\"+\"/db_ejemplos\", \"root\", \"\");\n            String query = \"CREATE TABLE LIBRO(isbn varchar(100) NOT NULL,name varchar(100) NOT NULL,PRIMARY KEY(isbn))\";\n            Statement stmt = con.createStatement();\n            String query1 = \"INSERT INTO LIBRO(isbn, name) values('232323sf', 'wdrwer')\";\n            stmt.executeUpdate(query1);\n        }catch (Exception e) {\n            System.out.println(e.getMessage());\n        }\n    }\n}"
		},
		{
			"id": "t7MTeaAU",
			"type": "text",
			"x": 1451.1992016613347,
			"y": -656.5925139135481,
			"width": 10,
			"height": 21,
			"angle": 0,
			"strokeColor": "#0b7285",
			"backgroundColor": "transparent",
			"fillStyle": "hachure",
			"strokeWidth": 1,
			"strokeStyle": "solid",
			"roughness": 1,
			"opacity": 100,
			"groupIds": [],
			"strokeSharpness": "sharp",
			"seed": 161791389,
			"version": 3,
			"versionNonce": 2094334461,
			"isDeleted": true,
			"boundElements": null,
			"updated": 1669742094582,
			"link": null,
			"locked": false,
			"text": "",
			"rawText": "",
			"fontSize": 16,
			"fontFamily": 1,
			"textAlign": "left",
			"verticalAlign": "top",
			"baseline": 14,
			"containerId": null,
			"originalText": ""
		}
	],
	"appState": {
		"theme": "light",
		"viewBackgroundColor": "#ffffff",
		"currentItemStrokeColor": "#0b7285",
		"currentItemBackgroundColor": "transparent",
		"currentItemFillStyle": "hachure",
		"currentItemStrokeWidth": 1,
		"currentItemStrokeStyle": "solid",
		"currentItemRoughness": 1,
		"currentItemOpacity": 100,
		"currentItemFontFamily": 1,
		"currentItemFontSize": 16,
		"currentItemTextAlign": "left",
		"currentItemStrokeSharpness": "sharp",
		"currentItemStartArrowhead": null,
		"currentItemEndArrowhead": "arrow",
		"currentItemLinearStrokeSharpness": "round",
		"gridSize": null,
		"colorPalette": {}
	},
	"files": {}
}
```
%%