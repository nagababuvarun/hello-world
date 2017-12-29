var index = 0;
var jsonArr = []; 

function addToCart(obj) {     var isValid = validatePoductRegister();     if(isValid){     var itemValues=[];     var elements = document.getElementById("formId").elements;     var validDets= true;     var jsonObj = "{";     for ( var i = 0; i < elements.length; i++) {         var item = elements.item(i);                      if(item.name !="" && item.name !=" " && item.value != null &&item.value !="" && item.type.indexOf('hidden')<0){                 jsonObj = jsonObj+"'"+item.name+"':'"+item.value+"',";                 itemValues.push(item.value);             } //            else{ //                if(item.name !=""){ //                    validDets = false; //                } //            }     }     if(validDets){     if(index=='0'){         createProductTitle();     }     jsonObj = jsonObj.substring(0, jsonObj.length-1)+"}";     var addedToTable = AddItemsToTable(itemValues);     if(addedToTable){         jsonArr.push(jsonObj);     }     index=index+1; //     ############dont delete it     $("form")[0].reset();       }else         alert('Please Enter Valid Product Details');     } }
function createProductTitle() {
	var table = '<table id="listTab"><tr>';
	$('.form-row span').each(function () {
		console.log($(this).text());
		if ($(this).text() != "") {
			table = table + "<th>" + $(this).text() + "</th>";
		}
	});
	table = table + "<th></th>";
	table = table + "</tr></table>";
	$('#productsListTab').append(table);
	$('#productsListTab').show();
}
var trIndex = 0;
function AddItemsToTable(items) {
	var added = false;
	if (items != "") {
		var tableRow = "<tr id='productTr-" + trIndex + "'>" for (var j = 0; j < items.length; j++) {
				if (j == items.length - 1) {
					tableRow = tableRow + '<td id="qunatityTd-' + saletrIndex + '">' + items[j] + '</td>';
				} else {
					tableRow = tableRow + '<td>' + items[j] + '</td>';
				}
			}
			tableRow = tableRow + '<td><a >Edit</a></td>';
		tableRow = tableRow + '<td><a >Delete</a></td>';
		tableRow = tableRow + "</tr>" $('#listTab').append(tableRow);
		trIndex = trIndex + 1;
		return true;
	}
}
var deleteMarkedIndexes = "";
var postJsonArr = [];
function saveProducts() {
	var visibleTrs = $('#listTab tr:visible').length;
	if (visibleTrs > 1) {
		console.log("delete marked Indexes" + deleteMarkedIndexes);
		if (deleteMarkedIndexes != null && deleteMarkedIndexes.length > 0) {
			for (var j = 0; j < jsonArr.length; j++) {
				if (deleteMarkedIndexes.indexOf(j) > -1) {}
				else {
					postJsonArr.push(jsonArr[j]);
				}
			}
		} else if (editIndex != null && editIndex != "") {
			mergeEditDets();
			postJsonArr = jsonArr;
		} else {
			postJsonArr = jsonArr;
		}
		$.post("addproducts.action", {
			'products' : "[" + postJsonArr + "]"
		}, function (res) {});
	} else {
		alert('Please Add Items ');
	}
}
function deleteItem(id) {
	var trIndex = id.split('-')[1];
	deleteMarkedIndexes = deleteMarkedIndexes + trIndex + ","; //jsonArr.splice(trIndex, 1);     $('#'+id).hide();     if($('#listTab tr:visible').length==1){              }      } var editJsonArr =[]; var editIndex=""; function editItem(id){     var trIndex = id.split('-')[1];     if(editIndex.indexOf(trIndex)<0){     var productDets = jsonArr[trIndex];     productDets=$.trim(productDets).replace(/'/g, '"');     var parsedJson = jQuery.parseJSON(productDets);     var quantity =parsedJson.quantity;     $('#qunatityTd-'+trIndex).empty();     var textField = '<input type="text" id="qunatityTdText-'+trIndex+'" class="qunatityTdcls-'+quantity+'" value="'+quantity+'"/>'     $('#qunatityTd-'+trIndex).append(textField);
	//    var jsonToString = JSON.stringify(parsedJson); //    jsonToString=$.trim(jsonToString).replace(/"/g, "'"); //    editSaleJsonArr['key-'+trIndex] = jsonToString;     editJsonArr['key-'+trIndex] = parsedJson;          //editSaleJsonArr.push(parsedJson);     editIndex=editIndex+trIndex+",";     }else{         alert('Already in Edit Format');     } } function mergeEditDets(){     for(key in editJsonArr){         var index =key.split('key-')[1];           var parsedJson = editJsonArr[key];           var updateQt = $('#qunatityTdText-'+index).val();           parsedJson.quantity=updateQt;                      var jsonToString = JSON.stringify(parsedJson);         jsonToString=$.trim(jsonToString).replace(/"/g, "'");         jsonArr[index]=jsonToString; } } function getEmpById(){     var empID = $('#empId').val();     if(empID != null && empID != ""){         $.post("editemp.action?req=sale",{'id':empID},function(res){                          if(res != null && res !='' ){             $('#empDetDiv').children().remove();             $('#empDetDiv').append(res);             $('#empDetDiv').show();             if(res.indexOf('No Employee')<0){             $('#addproductDiv').show();             }             }else{                 $('#addproductDiv').hide();             }
	$('#empDetId input').attr('readonly', 'readonly');
});
}
}
function SearchByProduct() {
	var productID = $('#productId').val();
	var productName = $('#productName').val();
	var header = $('.saleprodtab tr').length;
	var lastSno = $.trim($('#searchProductsDet table:last tr td:first').text());
	var newSno = 1;
	if (lastSno != null && lastSno != "") {
		newSno = parseInt(lastSno) + 1;
	}
	var headerexist = false;
	console.log(newSno);
	if (header != null && header > 0) {
		headerexist = true;
	}
	if ((productID != null && productID != "") || (productName != null && productName != "")) {
		$.post("searchByProduct.action?req=sale&headerexist=" + headerexist, $("#prodForm").serialize(), functio n(res) {
			if (res != null && res != '') {
				if (res.indexOf('No Details found') > 0) {
					alert("No Details Found");
				} else {
					$('#searchProductsDet').append(res);
					$('#searchProductsDet table:last tr td:first').text(newSno);
					var formId = $('#searchProductsDet form:last').attr('id');
					$('#searchProductsDet form:last').attr('id', formId + '-' + newSno);
					$('#searchProductsDet').show();
				}
			} else {
				$('#searchProductsDet').append(res);
				$('#searchProductsDet').hide();
			}
		});
	} else {
		alert('Please Provide Product Details');
	}
	$('#productId').val('');
}
function createTaJson() {
	var json = "{";
	$('[name^=tax_]').each(function () {
		var name = $(this).attr('name');
		var value = $(this).val();
		if (name != "" && name != " " && value != null && value != "") {
			name = name.split('_')[1];
			json = json + "'" + name + "':'" + value + "',";
		}
	});
	json = json.substring(0, json.length - 1) + "}";
	if (json != null) {
		$('#tax_hidden').val(json);
		return true;
	} else {
		return false;
	}
	alert(2)
}
var saleProdindex = 0;
var saleProductjsonArr = []; //        var jsondata =
"[{'empName':'Nagababu1','empRank':'SP','GNo':'4578','coy':'Acoy','empId':'78452215','tax':{'vat':14.5,'s t':3}},{'empName':'Nagababu2','empRank':'SP','GNo':'4578','coy':'Acoy','empId':'78452215','tax':{'vat':14 .5,'st':3}}]";
function addToSaleProductCart(obj) {
	var formId = $(obj).closest('form').attr('id');
	var itemValues = [];
	var itemNames = [];
	var quantity = 1.0;
	var customerPrice = 1.0;
	var purchasedQt = 1;
	var elements = document.getElementById(formId).elements;
	var saleProductjsonObj = "{";
	for (var i = 0; i < elements.length; i++) {
		var item = elements.item(i);
		if (item.id != "" && item.id != " ") {
			saleProductjsonObj = saleProductjsonObj + "'" + item.id + "':'" + item.value + "',";
			itemValues.push(item.value);
			itemNames.push(item.id);
			if (item.id == 'customerPrice') {
				customerPrice = parseFloat(item.value);
			} else if (item.id == 'quantity') {
				quantity = parseFloat(item.value);
				purchasedQt = parseInt($.trim($('#' + item.id).attr('class').split('-')[1]));
			}
		}
	}
	var totPrice = quantity * customerPrice;
	totPrice = roundPrice(totPrice);
	itemValues.push(totPrice);
	itemNames.push('TotalPrice');
	if (saleProdindex == '0') {
		createSaleProductTitle();
	}
	saleProductjsonObj = saleProductjsonObj.substring(0, saleProductjsonObj.length - 1) + "}";
	var addedToTable = AddItemsToSaleTable(itemValues, itemNames, purchasedQt);
	if (addedToTable) {
		saleProductjsonArr.push(saleProductjsonObj);
	}
	saleProdindex = saleProdindex + 1;
	console.log("add product sale" + saleProductjsonArr);
}
function createSaleProductTitle() {
	var table = '<table id="salelistTab"><tr>';
	$('.saleprodtab th').each(function () {
		if ($(this).text() != "" && $(this).text() != "s.no" && $(this).text().indexOf('select') < 0) {
			table = table + "<td>" + $(this).text() + "</td>";
		}
	});
	table = table + "<td>Total Price</td>";
	table = table + "<td></td>";
	table = table + "<td></td>";
	table = table + "</tr></table>";
	$('#selectedProducts').append(table);
	$('#selectedProducts').show();
	$('#billempId').val($('#empId').val());
	$('#billingDiv').show();
}
var saletrIndex = 0;
function AddItemsToSaleTable(items, itemNames, purchasedQt) {
	var added = false;
	if (items != "") {
		var tableRow = "<tr id='saleproductTr-" + saletrIndex + "'>" for (var j = 0; j < items.length; j++) { //console.log(items.name);             if(j==items.length-2){                 tableRow = tableRow+'<td class="'+itemNames[j]+"-"+saletrIndex+'" name="purQT-'+purchasedQt+'" id="qunatityTd-'+saletrIndex+'">'+items[j]+'</td>';             }else{             tableRow = tableRow+'<td class="'+itemNames[j]+"-"+saletrIndex+'">'+items[j]+'</td>';             }         }         tableRow = tableRow+'<td><a >'+saletrIndex+'\')">Edit</a></td>';         tableRow = tableRow+'<td><a >'+saletrIndex+'\')">Delete</a></td>';         tableRow=tableRow+"</tr>"         $('#salelistTab').append(tableRow);         saletrIndex = saletrIndex+1;     return true;     } } function deleteSaleItem(id){     var trIndex = id.split('-')[1];     deleteSaleMarkedIndexes=deleteSaleMarkedIndexes+trIndex+",";     //jsonArr.splice(trIndex, 1);     $('#'+id).hide();      } var deleteSaleMarkedIndexes = ""; var postSaleJsonArr = []; function sellProducts(){     var flag = true;     if(deleteSaleMarkedIndexes != null && deleteSaleMarkedIndexes.length >0){         flag =false;         for(var j=0 ;j<saleProductjsonArr.length;j++){             if(deleteSaleMarkedIndexes.indexOf(j)>-1){             }else{                 postSaleJsonArr.push(saleProductjsonArr[j]);             }         }
			}
			if (editSaleIndex != null && editSaleIndex != "") {
				flag = false;
				mergeEditSaleDets();
				postSaleJsonArr = saleProductjsonArr;
			}
			if (flag) { // no delete and Edit operations         postSaleJsonArr = saleProductjsonArr;     }     var empId = $('#empId').val().trim();     $.post("sellproducts.action",{'products':"["+postSaleJsonArr+"]",'empid':empId},function(res){         if(res != null && res != ""){             window.location.href="saleProductForm.action";         }     }); } //var editSaleJsonArr =[]; //var editSaleIndex=""; //function editSaleItem(id){ //    var trIndex = id.split('-')[1]; //    if(editSaleIndex.indexOf(trIndex)<0){ //    var productDets = saleProductjsonArr[trIndex]; //    productDets=$.trim(productDets).replace(/'/g, '"'); //    var parsedJson = jQuery.parseJSON(productDets); //    var quantity =parsedJson.quantity; //    $('#qunatityTd-'+trIndex).empty(); //    var textField = '<input type="text" id="qunatityTdText-'+trIndex+'" value="'+quantity+'"/>' //    $('#qunatityTd-'+trIndex).append(textField); //     //     ////    var jsonToString = JSON.stringify(parsedJson); ////    jsonToString=$.trim(jsonToString).replace(/"/g, "'"); ////    editSaleJsonArr['key-'+trIndex] = jsonToString; //    editSaleJsonArr['key-'+trIndex] = parsedJson; //     //    //editSaleJsonArr.push(parsedJson); //    editSaleIndex=editSaleIndex+trIndex+","; //    }else{ //        alert('Already in Edit Format'); //    } //}
				var editSaleJsonArr = [];
				var editSaleIndex = "";
				function editSaleItem(id) {
					var trIndex = id.split('-')[1];
					if (editSaleIndex.indexOf(trIndex) < 0) {
						var quantity = $('#qunatityTd-' + trIndex).attr('name').split('-')[1];
						var productDets = saleProductjsonArr[trIndex];
						productDets = $.trim(productDets).replace(/'/g, '"');
						var parsedJson = jQuery.parseJSON(productDets); //    var quantity =parsedJson.quantity;     $('#qunatityTd-'+trIndex).empty();     var textField = '<input type="text" id="qunatityTdText-'+trIndex+'" class="qunatityTdcls-'+quantity+'"  value="'+quantity+'"/>'     $('#qunatityTd-'+trIndex).append(textField);           //    var jsonToString = JSON.stringify(parsedJson); //    jsonToString=$.trim(jsonToString).replace(/"/g, "'");     editSaleJsonArr['key-'+trIndex] = parsedJson;     //editSaleJsonArr.push(parsedJson);     editSaleIndex=editSaleIndex+trIndex+",";     }else{         alert('Already in Edit Format');     } } function mergeEditSaleDets(){     for(key in editSaleJsonArr){         var index =key.split('key-')[1];           var parsedJson = editSaleJsonArr[key];           var updateQt = $('#qunatityTdText-'+index).val();           alert(updateQt);           parsedJson.quantity=updateQt;           console.log(parsedJson);           var jsonToString = JSON.stringify(parsedJson);         jsonToString=$.trim(jsonToString).replace(/"/g, "'");         saleProductjsonArr[index]=jsonToString; } }      $(function() {   $("#productName").autocomplete({
						source : function (request, response) {
							$.ajax({
								url : "productNameAutocomplete.action",
								data : {
									q : request.term
								},
								success : function (data) {
									response(data);
								},
								error : function () {
									response([]);
								}
							})
						}
					})
				});
				function validateEmployeeRegister() {
					var valid = $('#addemp').validate({
							rules : {
								empName : {
									required : true
								},
								empRank : {
									required : true
								},
								GNo : {
									required : true
								},
								coy : {
									required : true
								},
								empId : {
									required : true
								}
							},
							messages : {
								empName : "<br>Please Enter  Name",
								empRank : "<br>Please Enter Rank",
								GNo : "<br>Please Enter GNo",
								coy : "<br>Please Enter Coy",
								empId : "<br>Please Enter ID"
							}
						}).form();
					return valid;
				}
				function validateTaxRegister() {
					var test = $('#addtax').validate({
							rules : {
								taxName : {
									required : true
								},
								detaultTax : {
									required : true
								},
								applyOn : {
									required : true
								}
							},
							messages : {
								taxName : "<br>Please Enter  Tax Name",
								detaultTax : "<br>Please Enter Default Tax",
								applyOn : "<br>Please Select Apply On"
							},
						}).form();
				}
				function validateLogin() {
					var test = $('#login').validate({
							rules : {
								username : {
									required : true
								},
								password : {
									required : true
								}
							},
							messages : {
								username : "<br>Please Enter  User Name",
								password : "<br>Please Enter Password"
							},
						}).form();
				}
				function validatePoductRegister() {
					var test = $('#formId').validate({
							rules : {
								productId : {
									required : true
								},
								productName : {
									required : true
								},
								tax_ : {
									required : true
								},
								productPrice : {
									required : true,
									number : true
								},
								quantity : {
									required : true,
									number : true
								},
								purchaseDate : {
									required : true,
								}
							},
							messages : {
								productId : "<br>Please Enter  ProductID",
								productName : "<br>Please Enter Product Name",
								quantity : {
									required : "<br>Please Enter Quantity",
									number : "<br>Please Enter Valid Quantity"
								},
								productPrice : {
									required : "<br>Please Enter Product Price",
									number : "<br>Please Enter Valid Product Price"
								},
								purchaseDate : {
									required : "<br>Please Enter Purchase Date"
								}
							},
						}).form();
					return test;
				}
				function caluculateTotalPrice() {
					var itemPrice = $('#productPrice').val();
					if (itemPrice != null && itemPrice != "") {
						var totalPrice = parseFloat(itemPrice);
						$('.onProductPrice').each(function () {
							var percentage = $(this).val();
							if (percentage != null && percentage != '') {
								var calPrice = calcPercentage(itemPrice, percentage);
								totalPrice = totalPrice + calPrice;
							} else {
								alert('Please Enter Valid Tax Details');
							}
						});
						$('#storePrice').val(totalPrice);
						var totalCustPrice = totalPrice;
						$('.onTotalPrice').each(function () {
							var totpercentage = $(this).val();
							if (totpercentage != null && totpercentage != '') {
								var calcPrice = calcPercentage(totalCustPrice, totpercentage);
								totalCustPrice = totalCustPrice + calcPrice;
							} else {
								alert('Please Enter Valid Tax Details');
							}
						});
						$('#customerPrice').val(totalCustPrice);
					} else
						alert('Please Enter Product Price');
				}
				function calcPercentage(itemPrice, pertcentage) {
					return (parseFloat(itemPrice) * parseFloat(pertcentage)) / 100;
				}
				function checkQuantityVal(obj) {
					var qtclass = $(obj).attr('class');
					var availebleQt = parseInt(qtclass.split('-')[1]);
					var updatedQt = $(obj).val();
					if (updatedQt != null && updatedQt != '') {
						updatedQt = parseInt(updatedQt);
						if (updatedQt > availebleQt) {
							$(obj).val(availebleQt);
							alert('Quantity should not be exceed ' + availebleQt);
						} else {
							caluculateEditTotal(obj);
						}
					}
				}
				function caluculateEditTotal(obj) {
					var trIndex = $(obj).attr('id').split('-')[1];
					var quantity = $(obj).val();
					var customerPrice = $('.customerPrice-' + trIndex).text();
					var totalPrice = parseFloat(quantity) * parseFloat($.trim(customerPrice));
					totalPrice = roundPrice(totalPrice);
					$('.TotalPrice-' + trIndex).text(totalPrice);
				}
				function roundPrice(price) {
					return Math.round(price * 10000.0) / 10000.0;
				}
				Enter Comment