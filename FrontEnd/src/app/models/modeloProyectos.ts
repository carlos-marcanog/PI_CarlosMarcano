export class Proyectos {
    id?: number;
    nombre: string;
    descripcion: string;
    enlace: string;
    img: string;

    constructor(nombre: string, descripcion: string, enlace: string, img: string){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.enlace = enlace;
        this.img = img;
    }
}
