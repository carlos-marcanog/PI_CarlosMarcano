import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Experiencia } from 'src/app/models/modeloExperiencia';
import { ExperienciaService } from 'src/app/services/experiencia.service';

@Component({
  selector: 'app-editar-experiencia',
  templateUrl: './editar-experiencia.component.html',
  styleUrls: ['./editar-experiencia.component.css']
})
export class EditarExperienciaComponent implements OnInit {
  expLab : Experiencia = null; 
  constructor(private servicioExp: ExperienciaService, private actRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.actRouter.snapshot.params['id'];
    this.servicioExp.detalle(id).subscribe( data => {
      this.expLab = data;
    }, err =>{
      alert("No se pudo editar la Experiencia en OnINIT");
    });
  }

  onUpdate(): void{
    const id = this.actRouter.snapshot.params['id'];
    this.servicioExp.update(id, this.expLab).subscribe( data => {
      this.router.navigate(['']);
    }, err => {
      alert("No se pudo editar la Experiencia en OnUpdate");
      this.router.navigate(['']);
    })
  }
}
