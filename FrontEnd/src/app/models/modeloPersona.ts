export class Persona {
	id?: number;
	nombre: string;
	apellido: string;
	cargo: string;
	acercade: string;
	img: string;

	constructor(nombre: string, apellido: string, cargo: string, acercade: string, img: string) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.acercade = acercade;
		this.img = img;
	}
}
