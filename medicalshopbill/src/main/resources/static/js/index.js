$(document)
		.ready(
				function() {
					var counter = 0;
					populateMedicineName();
					$("#addrow")
							.on(
									"click",
									function() {
										var newRow = $("<tr>");
										var cols = "";

										cols += '<td class="center"><input type="text" list="medicinename" class="form-control" name="medicinename'
												+ counter + '"/><datalist id="medicinename"></datalist></td>';
										cols += '<td><input type="text" class="form-control" name="batchno'
												+ counter + '"/></td>';
										cols += '<td><input id="datepicker" class="form-control" name="expiredate'
												+ counter + '"/></td>';
										cols += '<td class="right"><input type="text" class="form-control" name="price'
												+ counter + '"/></td>';
										cols += '<td class="center"><input type="number" class="form-control" name="qty'
												+ counter + '"/></td>';
										cols += '<td class="right"><input type="button" class="form-control" name="total'
												+ counter + '"/></td>';
										cols += '<td class="right"><input type="button" class="ibtnDel btn btn-danger "  value="Delete"></td>';

										newRow.append(cols);
										$("table.table-striped").append(newRow);
										$(function () {
										    $("input[list=medicinename]").change(function () { //focusout
										       var mediName= $(this).val();
										       console.log('mediName='+mediName);
										       var id= $('#medicinename').find('option[value="' +mediName + '"]').attr('id');
										       console.log('id='+id);
										       $.ajax({
											        type : "GET",
											        dataType : 'json',
											        data:{id:id},
											        url : "api/medician",
											        success : function(data) {
											            console.log(data);
											            //var dataset=JSON.parse(data);
											            //alert(data[0].address1);
											            var options='';
											            $.each(data,function(k,v){
											              //  console.log(v);
											            	
											            	options = options+v+',';
											            	//console.log(options);
											                });  
											            
											           // console.log('options'+options);
											            var d=options.split(",");
											            //console.log(d[1]);
											           // console.log(d[2]);
											            var c=counter;
											            c=c-1;
											            $("input[name='batchno"+c+"']").val(''+d[2]);
										                $("input[name='expiredate"+c+"']").val(''+d[3]);
										                $("input[name='price"+c+"']").val(''+d[4]);
											            }
											        });
										    });
										})
										counter++;
									});

					$("#addrowupload")
							.on(
									"click",
									function() {
										var newRow = $("<tr>");
										var cols = "";

									cols += '<td class="center"><input type="text" list="medicinename" class="form-control" name="medicinename'
											+ counter + '"/></td>';
									cols += '<td><input type="text" class="form-control" name="batchno'
											+ counter + '"/></td>';
									cols += '<td><input id="datepicker" class="form-control" name="expiredate'
											+ counter + '"/></td>';
									cols += '<td class="right"><input type="text" class="form-control" name="price'
											+ counter + '"/></td>';
									cols += '<td class="right"><input type="button" class="ibtnDel btn btn-danger "  value="Delete"></td>';

										newRow.append(cols);
										$("table.table-striped").append(newRow);
										counter++;
									});

					$("#addrowupdate")
							.on(
									"click",
									function() {
										var newRow = $("<tr>");
										var cols = "";

										cols += '<td class="center"><input type="text" list="medicinename" class="form-control" name="medicinename'
												+ counter + '"/></td>';
										cols += '<td><input type="text" class="form-control" name="batchno'
												+ counter + '"/></td>';
										cols += '<td><input id="datepicker" class="form-control" name="expiredate'
												+ counter + '"/></td>';
										cols += '<td class="right"><input type="text" class="form-control" name="price'
												+ counter + '"/></td>';
										cols += '<td class="right"><input type="button" class="ibtnDel btn btn-danger "  value="Delete"></td>';

										newRow.append(cols);
										$("table.table-striped").append(newRow);
										counter++;
									});

					$("table.table-striped").on("click", ".ibtnDel",
							function(event) {
								$(this).closest("tr").remove();
								counter -= 1
							});
					 $("#savemedi").submit(function(event) {
							// Prevent the form from submitting via the browser.
							//event.preventDefault();
					    	var text = $('#savemedi').find('input[name="medicinename"]').val();
						    jsonObj = [];
						    alert("hi="+counter);
						    for (var i = 0; i <= counter; i++) {
						    	var j=i-1;
						        if (i == 0)
						        {
						        	item = {}
						            item ["medicineName"] = $('#savemedi').find('input[name="medicinename"]').val();
						            item ["batchNo"] = $('#savemedi').find('input[name="batchNo"]').val();
						            item ["expireDate"] = $('#savemedi').find('input[name="expireDate"]').val();
						            item ["price"] = $('#savemedi').find('input[name="price"]').val();
						            jsonObj.push(item);
						        }else{
						        	item = {}
						        	//alert(""+$('#savemedi').find('input[name="medicinename'+ j + '"]').val());
						            item ["medicineName"] = $('#savemedi').find('input[name="medicinename'+ j + '"]').val();
						            item ["batchNo"] = $('#savemedi').find('input[name="batchno'+ j + '"]').val();
						            item ["expireDate"] = $('#savemedi').find('input[name="expiredate'+ j + '"]').val();
						            item ["price"] = $('#savemedi').find('input[name="price'+ j + '"]').val();
						            jsonObj.push(item);
                                   
						        }
						    }
						    var jsonString = JSON.stringify(jsonObj);
						    alert("hi"+jsonString);
						    var url="http://localhost:9410/update";
						    $.ajax({
								type : "POST",
								contentType : "application/json",
								url : "api/savemedi",
								data : JSON.stringify(jsonObj),
								async: false,
						        //cache: false,
						       // timeout: 90000,
								success : function(result) {
									console.log(result);
									alert("success="+result);
							        window.location = url; 
									//console.log(result);
								},
								error : function(e) {
									alert("Error!")
									console.log("ERROR: ", e);
								}
							});
						});    
				
					$(function () {
					    $("input[list=medicinename]").change(function () { //focusout
					       var mediName= $(this).val();
					       console.log('mediName='+mediName);
					       var id= $('#medicinename').find('option[value="' +mediName + '"]').attr('id');
					       console.log('id='+id);
					       $.ajax({
						        type : "GET",
						        dataType : 'json',
						        data:{id:id},
						        url : "api/medician",
						        success : function(data) {
						           // console.log(data);
						            //var dataset=JSON.parse(data);
						            //alert(data[0].address1);
						            var options='';
						            $.each(data,function(k,v){
						              //  console.log(v);
						            	
						            	options = options+v+',';
						            	//console.log(options);
						                });  
						            
						          //  console.log('options'+options);
						            var d=options.split(",");
						            //console.log(d[1]);
						            $("input[name='batchno']").val(''+d[2]);
					                $("input[name='expiredate']").val(''+d[3]);
					                $("input[name='price']").val(''+d[4]);
						            }
						        });
					    });
					})
				   
				   
				});

$(function() {
	$("#datepicker").datepicker();
});

function calculateRow(row) {
	var price = +row.find('input[name^="price"]').val();
}

function sum() {
	console.log("sum");
}

function upload() {
	console.log("upload");
}

function update() {
	console.log("update");
}





function populateMedicineName() {
	//console.log("test");

	$.ajax({
		type : "GET",
		dataType : 'json',
		data : "",
		url : "api/medician/name",
		success : function(data) {
			//console.log(data);
			// var dataset=JSON.parse(data);
			// alert(data[0].address1);
			var options = '';
			$.each(data, function(k, v) {
				options += "<option id=" + v.id + " value='"+ v.mediName +"'>";
				//console.log(v);
			});
			//console.log(options);
			$("#medicinename").html(options);
		}
	});

}
