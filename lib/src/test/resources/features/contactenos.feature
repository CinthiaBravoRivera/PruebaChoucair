@contactenos
Feature: Contactenos Tests
 

	@CP0010M
  Scenario: Llenar formulario de contactenos      
    Given Abrir pagina web             
    When llenar formulario de contactenos
    Then validar el formulario
    
    
    @CP0020M
  Scenario: validar que el campo celular solo reciba numeros    
    Given Abrir pagina web             
    When lleno el campo de celular con letras
    Then valido que no aparezcan los valores