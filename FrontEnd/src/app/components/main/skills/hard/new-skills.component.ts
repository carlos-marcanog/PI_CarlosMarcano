import { Component, OnInit } from '@angular/core';
import { Skills } from 'src/app/models/modeloSkills';
import { SkillsService } from 'src/app/services/skills.service';

@Component({
  selector: 'app-new-skills',
  templateUrl: './new-skills.component.html',
  styleUrls: ['./new-skills.component.css']
})
export class NewSkillsComponent implements OnInit {

  nombreSkill: string;
  porcentaje: number;

  constructor(private servicioSkills: SkillsService) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const skill = new Skills(this.nombreSkill, this.porcentaje);
    this.servicioSkills.save(skill).subscribe({
      next: data => { alert("Skill Creada"), window.location.reload(); },
      error: err => { alert("Error al Crear Skill"), window.location.reload(); }
    });
  }

}
