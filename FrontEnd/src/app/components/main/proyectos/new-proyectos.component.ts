import { Component, OnInit } from '@angular/core';
import { Proyectos } from 'src/app/models/modeloProyectos';
import { ProyectosService } from 'src/app/services/proyectos.service';

@Component({
  selector: 'app-new-proyectos',
  templateUrl: './new-proyectos.component.html',
  styleUrls: ['./new-proyectos.component.css']
})
export class NewProyectosComponent implements OnInit {

  nombre: string;
  descripcion: string;
  enlace: string;
  img: string;

  constructor(private servicioProyecto: ProyectosService) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const proyecto = new Proyectos(this.nombre, this.descripcion, this.enlace, this.img);
    this.servicioProyecto.save(proyecto).subscribe({
      next: data => { alert("Proyecto Creado"), window.location.reload(); }
    });
  }
}
