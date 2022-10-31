import { Component, OnInit } from '@angular/core';
import { Proyectos } from 'src/app/models/modeloProyectos';
import { ProyectosService } from 'src/app/services/proyectos.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {

  proyecto: Proyectos[] = [];

  constructor(private servicioProyecto: ProyectosService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.cargarProyectos();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }

  cargarProyectos(): void{
    this.servicioProyecto.lista().subscribe({
      next: data => { this.proyecto = data }
    });
  }

  delete(id:number){
    if(id != undefined){
      this.servicioProyecto.delete(id).subscribe({
        next: data => { this.cargarProyectos() },
        error: err => { alert("No se puede eliminar el Proyecto") }
      });
    }
  }
}
