import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EpRequestComponent } from './ep-request.component';

describe('EpRequestComponent', () => {
  let component: EpRequestComponent;
  let fixture: ComponentFixture<EpRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EpRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EpRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
