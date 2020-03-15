$(document).ready(function() {
    $('#dob').datepicker(
	{
		format: 'yyyy-mm-dd'
	});
});

//DATA TABLE for list of patients
$(document).ready(function() {
    $('#listOfPatients').DataTable();
} );