export class Experiencia {
    id? : number;
    nombreExp : string;
    descripcionExp : string;
    cargo : string;
    fechaIngreso : string;
    fechaEgreso : string;

    constructor(nombreExp: string, descripcionExp:string, cargo:string, fechaIngreso:string, fechaEgreso:string){
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
        this.cargo = cargo;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
    }
}
