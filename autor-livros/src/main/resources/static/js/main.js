
// Autor Code
function loadAutorCode() {

	this.source = null;

	this.start = function() {

		var commentTable = document.getElementById("autorCodes");

		var bodyContent = document.getElementById("autorCodeBody");

		this.source = new EventSource("/monitor/autorCode");

		console.log("Check this out: 0 ");

		this.source.addEventListener("message", function(event) {

			//console.log("Check this out: 00 ");

			bodyContent.innerHTML = "";
			bodyContent.innerHTML = "<tr> </tr>";

			// These events are JSON, so parsing and DOM fiddling are needed
			// var comment = JSON.parse(event.data);

			var monitorEvento = JSON.parse(event.data);
			var autorCodes = monitorEvento.autorCodes;

			for (var i = 0; i < autorCodes.length; i++) {

				var row = commentTable.insertRow(commentTable.length);

				var cell0 = row.insertCell(0);

				cell0.className = "text";
				cell0.innerHTML = autorCodes[i].code;

			}


		}




		);

		this.source.onerror = function() {
			this.close();
		};

	};

	this.stop = function() {
		this.source.close();
	}

}

// Autores
function loadAutores() {

	this.source = null;

	this.start = function() {

		var commentTable = document.getElementById("autores");

		var bodyContent = document.getElementById("autorBody");

		this.source = new EventSource("/monitor/autores");

		//console.log("Check this out: 0 ");

		this.source.addEventListener("message", function(event) {

			//console.log("Check this out: 00 ");

			bodyContent.innerHTML = "";
			bodyContent.innerHTML = "<tr> </tr>";

			var monitorEvento = JSON.parse(event.data);
			var arrayAutores = monitorEvento.autores;

			//console.log("Check this out: 1 " + event.data);

			for (var i = 0; i < arrayAutores.length; i++) {

				//console.log("Check this out: 5 ");

				var autor = arrayAutores[i];

				var row = commentTable.insertRow(commentTable.length);

				var cell0 = row.insertCell(0);
				var cell1 = row.insertCell(1);
				
				cell0.className = "text";
				cell0.innerHTML = autor.codigo;

				cell1.className = "text";
				cell1.innerHTML = autor.nome;

			}




		});

		this.source.onerror = function() {
			this.close();
		};

	};

	this.stop = function() {
		this.source.close();
	}

}



// LIVROS
function loadLivros() {

	this.source = null;

	this.start = function() {

		var commentTable = document.getElementById("livros");

		var bodyContent = document.getElementById("livroBody");

		this.source = new EventSource("/monitor/livros");

		//console.log("Check this out: 0 ");

		this.source.addEventListener("message", function(event) {

			//console.log("Check this out: 00 ");

			bodyContent.innerHTML = "";
			bodyContent.innerHTML = "<tr> </tr>";

			var monitorEvento = JSON.parse(event.data);
			var arrayLivros = monitorEvento.livros;

			console.log("Check this out: 1 " + event.data);

			for (var i = 0; i < arrayLivros.length; i++) {

				//console.log("Check this out: 5 ");

				var livro = arrayLivros[i];

				var row = commentTable.insertRow(commentTable.length);

				var cell0 = row.insertCell(0);
				var cell1 = row.insertCell(1);
				var cell2 = row.insertCell(2);
				
				cell0.className = "text";
				cell0.innerHTML = livro.titulo;

				cell1.className = "text";
				cell1.innerHTML = livro.descricao;
				
				cell2.className = "text";
				cell2.innerHTML = livro.categoria;

			}




		});

		this.source.onerror = function() {
			this.close();
		};

	};

	this.stop = function() {
		this.source.close();
	}


}


// Autor Code
autorCode = new loadAutorCode();

// Autores
autores = new loadAutores();

// Livros
livros = new loadLivros();

/*
 * Register callbacks for starting and stopping the SSE controller.
 */

// ..
window.onload = function() {

	autorCode.start();
	autores.start();
	livros.start();

};


window.onbeforeunload = function() {

	autorCode.stop();
	autores.stop();
	livros.stop();

}