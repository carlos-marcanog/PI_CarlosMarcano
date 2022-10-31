import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyectos } from 'src/app/models/modeloProyectos';
import { ProyectosService } from 'src/app/services/proyectos.service';

@Component({
  selector: 'app-edit-proyectos',
  templateUrl: './edit-proyectos.component.html',
  styleUrls: ['./edit-proyectos.component.css']
})
export class EditProyectosComponent implements OnInit {

  proyecto: Proyectos = null;

  constructor(private servicioProyecto: ProyectosService, private actRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.actRouter.snapshot.params['id'];
    this.servicioProyecto.detalle(id).subscribe({
      next: data => { this.proyecto = data },
      error: err => { alert("Error al moificar la SoftSkill"), this.router.navigate(['']) }
    });
  }

  onUpdate(): void{
    const id = this.actRouter.snapshot.params['id'];
    this.servicioProyecto.update(id, this.proyecto).subscribe({
      next: data => { this.router.navigate(['']) },
      error: err => { alert("Error al moificar la SoftSkill"), this.router.navigate(['']) }
    });
  }

}
