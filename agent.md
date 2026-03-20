Refactor JUnit 4 test classes ONLY under the package:

<com.yourcompany.yourpackage.*>

Do not modify any classes outside this package.

Objective:
Add proper cleanup methods to prevent memory leaks and resource retention after test execution.

Requirements:

1. Identify JUnit 4 test classes (classes using @Test or extending test frameworks).

2. Add an @After method named "tearDown" if not already present:
   - Set non-primitive instance variables to null
   - Clear collections (List, Set, Map) before nullifying
   - Close open resources (InputStream, OutputStream, Readers, Writers)
   - Shutdown ExecutorService / thread pools using shutdownNow()
   - Remove ThreadLocal variables using remove()

3. Add an @AfterClass static method named "cleanUpClass" ONLY if static fields exist:
   - Clear static collections
   - Set static references to null

4. Ensure:
   - Null checks before cleanup
   - No NullPointerException
   - Idempotent cleanup (safe if executed multiple times)
   - Proper exception handling for close()

5. DO NOT:
   - Modify business logic or assertions
   - Add System.gc()
   - Change test behavior

6. Special handling:
   - Ensure servlet-related streams (e.g., ServletOutputStream) are flushed/closed if used
   - Clean any controller/service mocks holding references

7. Prefer reuse:
   - If a base test class exists in this package, add shared cleanup logic there instead of duplicating

8. Maintain:
   - Existing formatting and coding standards
   - Minimal and clean diff

Output:
- Only updated test classes within the specified package
- No changes outside scope