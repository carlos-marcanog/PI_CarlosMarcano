export class Educacion {
    id: number;
    nombreEdu: string;
    ubicacion: string;
    titulo: string;
    anioEgreso: string;

    constructor(nombreEdu: string, ubicacion: string, titulo: string, anioEgreso: string){
        this.nombreEdu = nombreEdu;
        this.ubicacion = ubicacion;
        this.titulo = titulo;
        this.anioEgreso = anioEgreso;
    }
}
