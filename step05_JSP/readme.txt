�н�����

1. jsp �⺻ tag
	1-1. scripting tag
		: <%����...%>
	- <%@ page import="" contentType="" %>
	
	1-2. jsp action tag
		<jsp:tag��>
	- page forward
		<jsp:forward page="�̵� page"/>
			<jsp:param name="��Ī" value="��"/>
		</jsp:forward>

2. EL tag
	- ${}
	- �ڹ� ������ ���
	- tag ���ο��� ����� ����, 
	- null�� ��� client���� blank�� view
	- ��Ű�ڵ� �����ϰ� ����
	- JSTL tag�� ����� �� Ȱ��� �� �ֵ��� ����
	
	- ����
		${requestScope.��Ī}
		${sessionScope.��Ī}
		${applicationScope.��Ī}
		
		${param.��������Ʈ����Ī}
		${cookie.��Ī.value}
		
3. JSTL tag �н�
	1. ���� ���� �ʼ� �ܰ�
		- �ܺ� library ���� ȯ������ download
		- db driver�� ���� ���� ��ó�� �ʼ�
		- web server�� web application�� library ���� ���
			WEB-INF/lib/*.jar	
			
	2. jsp ���Ϻ� �ݵ�� jstl����ϰڴٴ� ���� �ʼ�
	
4. client���� ���� ������ ���� ���
	1. forward ��Ľ� ���Ǵ� ��ü
		- HttpServletRequest
		- jsp�� ���尴ü(request)
	2. page�̵� ��İ� �����ϰ� ����ϴ� ��ü
		- HttpSession : jsp�� ���� ��ü(session)
		- Cookie	

5. ������ ���񽺸� �ϱ����� �ʱ�ȭ �۾�
	1. �Ϻ��� web application�� ������ ��ġ
	2. ������ �����Ѵ�
		* ���� �������� �ٶ󺸱�
			1. ���� ��ü�� ���� ���� Ȯ��(ip/port...)
			2. ���� �ϰ����ϴ� app~ ���� ���� ���ϵ� ���� �� �ʱ�ȭ
				- web.xml
			3. web app~ ���� ����
			4. web app~(web project) ���� ServletContext��� ��ü ����
				- ��� user(servlet�� jsp)�� ���Ǿ��� �����͸�
				   ����(setAtrribute())�ϰ� ���� ������ �ִ�(getAttribyte()) ������ ��ü
				- �����ڰ� ���� ���� ����, web server(container)�� ���� ����
			* ���� : 
				ServletContext�� ���� ��ü
				jsp�� application ���������� �����
				
	3. ���񽺸� �Ѵ�	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	