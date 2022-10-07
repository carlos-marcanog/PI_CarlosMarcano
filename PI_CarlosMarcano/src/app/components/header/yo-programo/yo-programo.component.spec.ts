import { ComponentFixture, TestBed } from '@angular/core/testing';

import { YoProgramoComponent } from './yo-programo.component';

describe('YoProgramoComponent', () => {
  let component: YoProgramoComponent;
  let fixture: ComponentFixture<YoProgramoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ YoProgramoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(YoProgramoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
