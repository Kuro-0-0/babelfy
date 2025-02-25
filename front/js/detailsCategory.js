
var categoryName;

  //This event waits for the content of the page to load to make sure the function works okay 
  document.addEventListener('DOMContentLoaded', function() {

    showCategoryDetails();

  });

  function showCategoryDetails() {
    
    //This is the endPoint, it uses the saved Id to show the category
    const apiUrl = 'http://localhost:9000/categories/'+localStorage.getItem('idCategory');

    //Then this calls the 'API' from the categoryController that brings that method
    fetch(apiUrl)

      .then(function(response) {
        if (!response.ok) {
          //This error is thrown so that (if an error occurs) gets to the .catch
          throw new Error('Error en la respuesta de la API: ' + response.statusText);
        }
        //This is .json because the render function needs it to be in this format
        return response.json();
      })
      
      .then(function(category) {
        renderCategoryDetails(category);
      })

      //This .catch is here to show through the console any errors that could appear 
      .catch(function(error) {
        console.error('Error al cargar la categoria', error);

        //This also shows that there was an error but through the html
        document.getElementById('sectionDetails').innerHTML = '<div><h1 class="error">Error</h1><p>Something went wrong with the server connection.</p></div>';
      });
  }


  function renderCategoryDetails(category) {
    console.log(category);
    
    //This gets an objects in the html with the Id 'name'
    var title = document.getElementById('name');
    var div = document.getElementById('songsTable');

    if(category.songs.length<=0){
      div.innerHTML = ''
      div.innerHTML =       
      "<h1 class='error'>Comment</h1>" +
      "<p>This category does not have any song</p>"
    }else{
      div.innerHTML = ''
      var table = document.createElement('table');
      var tbody = document.createElement('tbody');
      table.innerHTML =
          `<thead>
          <tr>
            <th>Name</th>
            <th>Duration</th>
            <th>Artist</th>
            <th>Album</th>
            <th>Release Date</th>
            <th></th>
          </tr>
          </thead>`
          div.appendChild(table);
          table.appendChild(tbody);
      category.songs.forEach(function (song){
        var row = document.createElement('tr');
        row.innerHTML = `
          
          <td>${song.name}</td>
          <td>${song.duration}</td>
          <td>${song.artistName}</td>
          <td>${song.albumName}</td>
          <td>${song.releaseDate}</td>
          <td><a href="" title="Delete from category"><i class="bi bi-x-square-fill"></i></a></td>
        `
        
        tbody.appendChild(row);
      })
    
    }
    //This 'category.name' is from the .json that we got from before
    categoryName=category.name;
    title.innerHTML = categoryName + "  ";
    var pen = document.createElement('i');
    pen.classList='bi bi-pencil-fill';
    pen.id='clickForShowing';
    pen.onclick = showChanger;

    //This links the objects, saying that, whats in (), is inside of the other one
    title.appendChild(pen);
    
  }

  function showChanger(){
    var container = document.getElementById('updateCategory');

    if(container.style.display=='block'){
      container.style.display='none';
      document.getElementById('clickForShowing').disabled = false;
    }else{
      document.getElementById('clickForShowing').disabled = true;
      container.style.display='block';
      var name = document.getElementById('newName');
      name.value = categoryName;
    }
  }

  function changeName(){
    try {

      var submitter = document.getElementById('newName');
      var categoryId = localStorage.getItem('idCategory');
      const apiUrlChange ='http://localhost:9000/categories';
      var nameValue = checkText(submitter.value);
      
      //This could be an error because the checkText function could return one
      if(nameValue instanceof Error){
        throw new Error (nameValue.message)
      }
      
      //This options are needed to 'send back' the changes
      options={
        method: "put",
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify ({
          'id': localStorage.getItem('idCategory'),
          'name': submitter.value
        })
      }
      fetch(apiUrlChange,options)

      .then(function(response){

        //This 'ok' means that the status is a 200
        if (response.ok){
          estado = 'Message'
          showCategoryDetails();
      } else {
          estado = 'Error'
      }
        return response.text()
      })

      .then(text => {
        //Calling again this function makes it disappear (revert the show)
        showChanger();
            
        showPopUp(estado,text)
        var popupTitle = document.getElementById('TitlePopUp');
        popupTitle.style.color ='#cdefed';
      })

      .catch(function(error) {

        console.error('Error al cargar la categoria', error);
        document.getElementById('main').innerHTML = '<p>Error al cargar la categoria.</p>';
      });

    } catch (error) {
      showPopUp('Error',error.message)
    }
  }

//The submit button in the form refreshes the page automatically, so this prevents that
document.getElementById('createForm').addEventListener('submit', function(event){
  event.preventDefault();
});



