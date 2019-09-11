import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditVueloComponent } from './edit-vuelo.component';

describe('EditBillComponent', () => {
  let component: EditVueloComponent;
  let fixture: ComponentFixture<EditVueloComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditVueloComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditVueloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
