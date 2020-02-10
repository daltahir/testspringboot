@AutoConfigureMockMvc
@WebMvcTest
class WebControllerTest extends Specification {
 
    @Autowired
    private UsuarioController mvc
 
    def "when get is performed then the response has status 200 and content is 'Hello world!'"() {
        expect: "Status is 200 and the response is 'Hello world!'"
        mvc.perform(get("/Registro"))
          .andExpect(status().isOk())
          .andReturn()
          .response
          .contentAsString == "Hello world!"
    }
}