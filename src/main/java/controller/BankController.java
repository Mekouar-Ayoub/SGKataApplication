/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Mekouar Ayoub
 */
@RestController
@RequestMapping(value = "/services")
public class BankController {

    @Autowired
    private IBanAccountkService bankAccountService;
    private IOperationHistoryRepository operationHistoryService;
    private IOperationService operationService;
    private static Logger logger = Logger.getLogger(ServiceBankRest.class);
    
    
    @RequestMapping(value = "/deposit", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> deposit(@RequestBody Operation operation) {
		try {
			double amount = operation.getAmount();
			bankAccountService.deposit(amount);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
        
        // http://localhost:8080/services/withdrawal
	@RequestMapping(value = "/withdrawal", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> withdrawal(@RequestBody Operation operation) {
		try {
			double amount = operation.getAmount();
			bankService.withdrawal(amount);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
        
        @RequestMapping(value = "/operations", method = RequestMethod.GET)
	public ResponseEntity<List<Operation>> listOperation(){
		
		List<Operation> operations=null;
		try {
			operations = OperationHistoryService.listAllOperations();
		} catch (Exception e) {
			return new ResponseEntity<List<Operation>>(operations, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Operation>>(operations, HttpStatus.OK);
		
	}
}
