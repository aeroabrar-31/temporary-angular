import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AbrarComponent } from './abrar.component';

describe('AbrarComponent', () => {
  let component: AbrarComponent;
  let fixture: ComponentFixture<AbrarComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AbrarComponent]
    });
    fixture = TestBed.createComponent(AbrarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
