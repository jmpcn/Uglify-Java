"use strict";

var UglifyJS = require("uglify-js2");

var tokenizer = UglifyJS.tokenizer("\"use strict\";\r\nfunction sum(x, y){ return x + y }");


var token  = tokenizer();

debugger;

while (token.type != "eof")
{
console.log(token);
	token  = tokenizer();	
}

console.log(token);