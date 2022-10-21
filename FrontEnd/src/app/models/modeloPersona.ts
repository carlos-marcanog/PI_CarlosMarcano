export class Persona {
	id?: number;
	nombre: String;
	apellido: String;
	telefono: String;

	constructor(nombre: String, apellido: String, telefono: String) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}
}
