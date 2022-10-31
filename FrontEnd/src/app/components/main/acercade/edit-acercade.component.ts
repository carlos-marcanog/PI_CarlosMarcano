import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Persona } from 'src/app/models/modeloPersona';
import { ImageService } from 'src/app/services/image.service';
import { PersonaService } from 'src/app/services/persona.service';

@Component({
  selector: 'app-edit-acercade',
  templateUrl: './edit-acercade.component.html',
  styleUrls: ['./edit-acercade.component.css']
})
export class EditAcercadeComponent implements OnInit {

  persona: Persona = null;

  constructor(private servicioPersona: PersonaService, private actRouter: ActivatedRoute, private router: Router, public servicioImg: ImageService) { }

  ngOnInit(): void {
    const id = this.actRouter.snapshot.params['id'];
    this.servicioPersona.detalle(id).subscribe({
      next: data => {  this.persona = data },
      error: err => { alert("Error al modificar"), this.router.navigate([''])  }
    });
  }

  onUpdate(): void{
    const id = this.actRouter.snapshot.params['id'];
    this.persona.img = this.servicioImg.url
    this.servicioPersona.update(id, this.persona).subscribe({
      next: data => { this.router.navigate(['']) },
      error: err => { alert("Error al modificar"), this.router.navigate(['']) }
    });
  }

  uploadImg($event:any){
    const id = this.actRouter.snapshot.params['id'];
    const name = "perfil_" + id;
    this.servicioImg.uploadImg($event, name);
  }
}
