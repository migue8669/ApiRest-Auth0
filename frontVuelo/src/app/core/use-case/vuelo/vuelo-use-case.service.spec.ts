import { TestBed } from "@angular/core/testing";
import { VueloUseCaseService } from "./vuelo-use-case.service";
//import { SofkianoService } from "../../services/sofkiano/sofkiano.service";
import { HttpClientTestingModule } from "@angular/common/http/testing";
import { VueloService } from "../../services/vuelo/vuelo.service";

describe("SofkianoUseCaseService", () => {
  let vueloUseCaseService: VueloUseCaseService;
  let vueloService: VueloService;
  let spy;
  let spyPost;
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [VueloUseCaseService,VueloService]
    });
    vueloUseCaseService = TestBed.get(vueloUseCaseService);
    vueloService = TestBed.get(vueloService);
    spy = spyOn(vueloService, "getAllVuelo").and.callThrough();
    spyPost = spyOn(vueloService, "saveNewVuelo").and.callThrough();
  });

  it("should be created sofkiano service use-case", () => {
    expect(vueloUseCaseService).toBeTruthy();
  });

  it("the sofkianoService integrated with SofkianoUseCaseService ", () => {
    vueloUseCaseService = new VueloUseCaseService(spy);
    expect(vueloUseCaseService.getAllVueloService).toBeTruthy();
  });

  it("post method SofkianoService intedrated with SofkianoUseCaseService", () => {
    vueloUseCaseService = new VueloUseCaseService(spyPost);
    expect(vueloUseCaseService.postVueloervice).toBeTruthy();
  });
});
