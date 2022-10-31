import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Skills } from 'src/app/models/modeloSkills';
import { SkillsService } from 'src/app/services/skills.service';

@Component({
  selector: 'app-edit-skills',
  templateUrl: './edit-skills.component.html',
  styleUrls: ['./edit-skills.component.css']
})
export class EditSkillsComponent implements OnInit {

  skill: Skills = null;

  constructor(private servicioSkill: SkillsService, private actRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.actRouter.snapshot.params['id'];
    this.servicioSkill.detail(id).subscribe({
      next: data => { this.skill = data },
      error: err => { alert("Error al moificar la Skill"), this.router.navigate(['']) }
    });
  }

  onUpdate(): void{
    const id = this.actRouter.snapshot.params['id'];
    this.servicioSkill.update(id, this.skill).subscribe({
      next: data => { this.router.navigate(['']) },
      error: err => { alert("Error al moificar la Skill"), this.router.navigate(['']) }
    });
  }
}
