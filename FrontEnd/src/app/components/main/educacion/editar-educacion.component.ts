import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Educacion } from 'src/app/models/modeloEducacion';
import { EducacionService } from 'src/app/services/educacion.service';

@Component({
  selector: 'app-editar-educacion',
  templateUrl: './editar-educacion.component.html',
  styleUrls: ['./editar-educacion.component.css']
})
export class EditarEducacionComponent implements OnInit {

  edu: Educacion = null;

  constructor(private servicioEdu: EducacionService, private actRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.actRouter.snapshot.params['id'];
    this.servicioEdu.detalle(id).subscribe({
      next: data => { this.edu = data },
      error: err => { alert("Error al moificar la educacion"), this.router.navigate(['']) }
    })
  }

  onUpdate(): void{
    const id = this.actRouter.snapshot.params['id'];
    this.servicioEdu.update(id, this.edu).subscribe({
      next: data => { this.router.navigate(['']) },
      error: err => { alert("Error al moificar la educacion"), this.router.navigate(['']) }
    });
  }
}
