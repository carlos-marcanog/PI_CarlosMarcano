export class Persona {
	id?: number;
	nombre: String;
	apellido: String;
	cargo: String;
	acercade: String;

	constructor(nombre: String, apellido: String, cargo: String, acercade: String) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.acercade = acercade;
	}
}
