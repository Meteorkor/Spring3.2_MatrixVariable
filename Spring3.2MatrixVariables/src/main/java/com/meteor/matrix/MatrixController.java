package com.meteor.matrix;

import org.apache.log4j.varia.FallbackErrorHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MatrixController {

	
	/**
	 * localhost:8080/param?bookId=11
	 * RequstParam 예제
	 * @param pathVal
	 * @return
	 */
	@RequestMapping(value="param", method=RequestMethod.GET)
	public @ResponseBody String getRequstParam( @RequestParam("bookId") String bookId ){
		
		
		StringBuilder returnVal = new StringBuilder();
		returnVal.append( "bookId = " + bookId );
		
		return returnVal.toString(); 
	}
	
	/**
	 * localhost:8080/Book
	 * PathVariable 예제
	 * @param pathVal
	 * @return
	 */
	@RequestMapping(value="{pathVal}", method=RequestMethod.GET)
	public @ResponseBody String getPathVal( @PathVariable("pathVal") String pathVal ){
		
		
		StringBuilder returnVal = new StringBuilder();
		returnVal.append( "pathVal = " + pathVal );
		
		return returnVal.toString(); 
	}
	
	
	/**
	 * localhost:8080/bookId=11;
	 * MatrixVariable 예제
	 * @param pathVal
	 * @return
	 */
	@RequestMapping(value="books/{pathVal}", method=RequestMethod.GET)
	public @ResponseBody String getMatrixVal_1_1( @PathVariable String pathVal, @MatrixVariable(required=false) String bookId ){
		
		
		StringBuilder returnVal = new StringBuilder();
		returnVal.append( "pathVal = " + pathVal );
		returnVal.append( "<br>" );
		returnVal.append( "bookId = " + bookId );
		
		return returnVal.toString(); 
	}
	
	/**
	 * localhost:8080 books/bookId=11/bookName=Toby;
	 * MatrixVariable 예제
	 * @param pathVal
	 * @return
	 */
	@RequestMapping(value="books/{pathNumber}/{pathName}", method=RequestMethod.GET)
	public @ResponseBody String getMatrixVal_2_1( @MatrixVariable(pathVar="pathNumber", value="bookId") String bookId, @MatrixVariable(pathVar="pathName", value="bookName") String bookName ){
		
		StringBuilder returnVal = new StringBuilder();
		returnVal.append( "bookId = " + bookId );
		returnVal.append( "<br>" );
		returnVal.append( "bookName = " + bookName );
		
		return returnVal.toString(); 
	}
	
}
